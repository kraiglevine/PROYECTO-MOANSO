
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.InventarioDAO;
import models.Proveedor;
import views.Proveedor_Principal;

public class ProveedorController implements ActionListener{
    DefaultTableModel modeloTabla3=new DefaultTableModel();
    Proveedor_Principal vista3=new Proveedor_Principal();
    InventarioDAO dao=new InventarioDAO();
    
    public ProveedorController (Proveedor_Principal proveedor){
        this.vista3=proveedor;
        this.vista3.btnListar.addActionListener(this);
        this.vista3.btnRegistrar.addActionListener(this);
        this.vista3.btnNuevo.addActionListener(this);
        this.vista3.btnEditar.addActionListener(this);
        this.vista3.btnEliminar.addActionListener(this); 
        this.vista3.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista3.btnListar){
            limpiarTablaProveedor();
            listarProveedor(vista3.tbProveedores);
        }
        if(e.getSource()==vista3.btnRegistrar){
            agregarProveedor();
            limpiarCajasProveedor();
            limpiarTablaProveedor();
            listarProveedor(vista3.tbProveedores);
        }
        if(e.getSource()==vista3.btnEditar){
            vista3.btnRegistrar.setEnabled(false);
            vista3.btnEliminar.setEnabled(false);
            vista3.btnActualizar.setEnabled(true);
            int fila=vista3.tbProveedores.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista3, "Debe selecionar una fila...");
        }else{
            int id= Integer.parseInt((String)vista3.tbProveedores.getValueAt(fila, 0).toString());
            String social= (String)vista3.tbProveedores.getValueAt(fila,1);
            String ruc=(String)vista3.tbProveedores.getValueAt(fila,2);
            String direccion=(String)vista3.tbProveedores.getValueAt(fila,3);
            String correo=(String)vista3.tbProveedores.getValueAt(fila, 4);
            String telefono=(String)vista3.tbProveedores.getValueAt(fila, 5);
            
            vista3.txtId.setText(id+"");
            vista3.txtRazonSocial.setText(social);
            vista3.txtRUC.setText(ruc);
            vista3.txtDireccion.setText(direccion);
            vista3.txtCorreo.setText(correo);
            vista3.txtCelular.setText(telefono);
            }
        }
        if(e.getSource()==vista3.btnActualizar){
            actualizarProveedor();
            limpiarTablaProveedor();
            listarProveedor(vista3.tbProveedores);
            limpiarCajasProveedor();
            vista3.btnActualizar.setEnabled(false);
            vista3.btnEliminar.setEnabled(true);      
        }
         if(e.getSource()==vista3.btnEliminar){
            eliminarProveedor();
            limpiarTablaProveedor();
            listarProveedor(vista3.tbProveedores);
        }
        if(e.getSource()==vista3.btnNuevo){
            limpiarCajasProveedor();
            vista3.btnRegistrar.setEnabled(true); 
            vista3.btnActualizar.setEnabled(false);
            vista3.btnEliminar.setEnabled(true);    
        }
        
    }
    public void eliminarProveedor(){
        int fila= vista3.tbProveedores.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista3, "Debe seleccionar una fila!!"); 
        }else{
            int id=Integer.parseInt((String)vista3.tbProveedores.getValueAt(fila, 0).toString());
            this.dao.eliminarProveedor(id);
            JOptionPane.showMessageDialog(vista3, "Proveedor eliminado");
        }
        
    }
    
    public void actualizarProveedor(){
        int id=Integer.parseInt(vista3.txtId.getText());
        String social= (String)vista3.txtRazonSocial.getText();
        String ruc=(String)vista3.txtRUC.getText();
        String direccion=(String)vista3.txtDireccion.getText();
        String correo=(String)vista3.txtCorreo.getText();
        String telefono=(String)vista3.txtCelular.getText();

        if(social.equals("")||ruc.equals("")||direccion.equals("")||correo.equals("")||telefono.equals("")){
            JOptionPane.showMessageDialog(vista3, "Debe llenar todos los campos");    
        }else{
             Proveedor proveedor=new Proveedor (id,social, ruc, direccion, correo, telefono);
             int r= this.dao.actualizarProveedor(proveedor);
             if(r==1){
                 JOptionPane.showMessageDialog(vista3, "Proveedor actualizado con exito...");
             }else{
                 JOptionPane.showMessageDialog(vista3, "Error al actualizar proveedor!!!");
             }
        } 
    }
    public void agregarProveedor(){
        String social= (String)vista3.txtRazonSocial.getText();
        String ruc=(String)vista3.txtRUC.getText();
        String direccion=(String)vista3.txtDireccion.getText();
        String correo=(String)vista3.txtCorreo.getText();
        String telefono=(String)vista3.txtCelular.getText();

        if(social.equals("")||ruc.equals("")||direccion.equals("")||correo.equals("")||telefono.equals("")){
            JOptionPane.showMessageDialog(vista3, "Debe llenar todos los campos");    
        }else{
             Proveedor proveedor=new Proveedor (social, ruc, direccion, correo, telefono);
             int r= this.dao.agregarProveedor(proveedor);
             if(r==1){
                 JOptionPane.showMessageDialog(vista3, "Proveedor agregado con exito...");
             }else{
                 JOptionPane.showMessageDialog(vista3, "Error al agregar proveedor!!!");
             }
        } 
    } 
        
    public void listarProveedor(JTable tabla){
        this.modeloTabla3=(DefaultTableModel)tabla.getModel();
        List<Proveedor>listaProveedor=this.dao.listarProveedor();
        Object[] objeto=new Object[6];
        for(int i=0;i<listaProveedor.size();i++){
            objeto[0]=listaProveedor.get(i).getID();
            objeto[1]=listaProveedor.get(i).getSocial();
            objeto[2]=listaProveedor.get(i).getRUC();
            objeto[3]=listaProveedor.get(i).getDireccion();
            objeto[4]=listaProveedor.get(i).getCorreo();
            objeto[5]=listaProveedor.get(i).getTelefono();
            modeloTabla3.addRow(objeto);  
        }
        vista3.tbProveedores.setModel(modeloTabla3); 
    }
    
    public void limpiarTablaProveedor(){
        for(int i=0;i<vista3.tbProveedores.getRowCount();i++){
            modeloTabla3.removeRow(i);
            i=i-1;
        }
    }
    
    public void limpiarCajasProveedor(){
        vista3.txtId.setText("");
        vista3.txtCelular.setText("");
        vista3.txtCorreo.setText("");
        vista3.txtDireccion.setText("");
        vista3.txtId.setText("");
        vista3.txtRUC.setText("");
        vista3.txtRazonSocial.setText("");  
    }
}

