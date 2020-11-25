package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.Producto;
import models.InventarioDAO;
import views.Inventario_Principal;
import views.Pedido_Principal;


public class InventarioController implements ActionListener {
    DefaultTableModel modeloTabla=new DefaultTableModel();
    Inventario_Principal vista=new Inventario_Principal();
    Pedido_Principal view=new Pedido_Principal();
    InventarioDAO dao=new InventarioDAO();
    
    public InventarioController(Inventario_Principal principal){
        this.vista=principal;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this); 
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this); 
        this.vista.btnNuevo.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListar){
            limpiarTabla();
            listar(vista.tbProductos);
        }
        if(e.getSource()==vista.btnAgregar){
            agregar();
            limpiarCajas();
            limpiarTabla();
            listar(vista.tbProductos);
        }
        if(e.getSource()==vista.btnEditar){
            vista.btnAgregar.setEnabled(false);
            vista.btnEliminar.setEnabled(false);
            vista.btnActualizar.setEnabled(true);
            int fila=vista.tbProductos.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista, "Debe selecionar una fila...");
        }else{
            int id= Integer.parseInt((String)vista.tbProductos.getValueAt(fila, 0).toString());
            String codigo= (String)vista.tbProductos.getValueAt(fila,1);
            String especie=(String)vista.tbProductos.getValueAt(fila,2);
            String cantidad=(String)vista.tbProductos.getValueAt(fila,3);
            String procedencia=(String)vista.tbProductos.getValueAt(fila, 4);
            String proveedor=(String)vista.tbProductos.getValueAt(fila, 5);

                
            vista.txtID.setText(id+"");
            vista.txtCodigo.setText(codigo);
            vista.txtEspecie.setText(especie);
            vista.txtCantidad.setText(cantidad);
            vista.txtProcedencia.setText(procedencia);
            vista.txtProveedor.setText(proveedor);
            }
        } 
        if(e.getSource()==vista.btnActualizar){
            actualizar();
            limpiarTabla();
            listar(vista.tbProductos);
            limpiarCajas();
            vista.btnActualizar.setEnabled(false);
            vista.btnEliminar.setEnabled(true);      
        }
        if(e.getSource()==vista.btnEliminar){
            eliminar();
            limpiarTabla();
            listar(vista.tbProductos);
        }
        if(e.getSource()==vista.btnNuevo){
            limpiarCajas();
            vista.btnAgregar.setEnabled(true); 
            vista.btnActualizar.setEnabled(false);
            vista.btnEliminar.setEnabled(true);    
        }
    }
    
    private void eliminar(){
        int fila =vista.tbProductos.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila!!");
        }else{
            int id=Integer.parseInt((String)vista.tbProductos.getValueAt(fila,0).toString());
            this.dao.eliminar(id);
            JOptionPane.showMessageDialog(vista, "Producto eliminada");
        }
    } 
    
    private void actualizar(){
        int id= Integer.parseInt(vista.txtID.getText());
        String codigo= vista.txtCodigo.getText();
        String especie= vista.txtEspecie.getText();
        String cantidad= vista.txtCantidad.getText();
        String procedencia=vista.txtProcedencia.getText();
        String proveedor=vista.txtProveedor.getText();
        
        if(codigo.equals("")||especie.equals("")||cantidad.equals("")||procedencia.equals("")||proveedor.equals("")){
            JOptionPane.showMessageDialog(vista, "Debe llenar todos los campos");
        }else{
             Producto inventario=new Producto(id, codigo, especie, cantidad,procedencia, proveedor);
             int r= this.dao.actualizar(inventario);
             if(r==1){
                 JOptionPane.showMessageDialog(vista, "Producto actualizado con exito...");
             }else{
                 JOptionPane.showMessageDialog(vista, "Error al actualizar producto!!!");
             }
        } 
    }

    private void agregar(){    
        String codigo= vista.txtCodigo.getText();
        String especie= vista.txtEspecie.getText();
        String cantidad= vista.txtCantidad.getText();
        String procedencia=vista.txtProcedencia.getText();
        String proveedor=vista.txtProveedor.getText();
 
        if(codigo.equals("")||especie.equals("")||cantidad.equals("")||procedencia.equals("")||proveedor.equals("")){
            JOptionPane.showMessageDialog(vista, "Debe llenar todos los campos");
        }else{
             Producto inventario=new Producto(codigo, especie, cantidad,procedencia, proveedor);
        int rpta=this.dao.agregar(inventario);
        if(rpta==1){
            JOptionPane.showMessageDialog(vista, "Producto registrado con exito");
        }else{
            JOptionPane.showMessageDialog(vista, "Error al registrar producto");
        }
        }
    }
    
    private void listar(JTable tabla){
        this.modeloTabla=(DefaultTableModel)tabla.getModel();
        List<Producto>listaInventario=this.dao.listar();
        Object[] objeto=new Object[6];
        for(int i=0;i<listaInventario.size();i++){
            objeto[0]=listaInventario.get(i).getId();
            objeto[1]=listaInventario.get(i).getCodigo();
            objeto[2]=listaInventario.get(i).getEspecie();
            objeto[3]=listaInventario.get(i).getCantidad();
            objeto[4]=listaInventario.get(i).getProcedencia();
            objeto[5]=listaInventario.get(i).getProveedor();
            modeloTabla.addRow(objeto);  
        }
        vista.tbProductos.setModel(modeloTabla);
    }
     
    private void limpiarTabla(){
        for(int i=0;i<vista.tbProductos.getRowCount();i++){
            modeloTabla.removeRow(i);
            i=i-1;
        }
    }
    
    private void limpiarCajas(){
        vista.txtID.setText("");
        vista.txtCodigo.setText("");
        vista.txtEspecie.setText("");
        vista.txtCantidad.setText("");
        vista.txtProcedencia.setText("");
        vista.txtProveedor.setText("");
    }
}
 


