
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.InventarioDAO;
import models.Pedido;
import views.Pedido_Principal;


public class PedidoController implements ActionListener{
    DefaultTableModel modeloTabla5=new DefaultTableModel();
    DefaultTableModel modeloTabla6=new DefaultTableModel();
    DefaultTableModel modeloTabla7=new DefaultTableModel();
    Pedido_Principal vista5=new Pedido_Principal();
    InventarioDAO dao=new InventarioDAO();
    
    public PedidoController (Pedido_Principal pedido){
        this.vista5=pedido;
        this.vista5.btnListar.addActionListener(this);
        this.vista5.btnNuevo.addActionListener(this);
        this.vista5.btnEditar.addActionListener(this);
        this.vista5.btnEliminar.addActionListener(this);
        this.vista5.btnRegistrar.addActionListener(this);
        this.vista5.btnActualizar.addActionListener(this);
        this.vista5.btnSearchProduct.addActionListener(this);
        this.vista5.btnSearchClient.addActionListener(this);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if(e.getSource()==vista5.btnListar){
            limpiarTablaPedido();
            listarPedido(vista5.tbPedido);           
        }
        if(e.getSource()==vista5.btnRegistrar){
            agregarPedido();
            limpiarCajasPedido();
            limpiarTablaPedido();
            listarPedido(vista5.tbPedido);
        }
        if(e.getSource()==vista5.btnEditar){
            vista5.btnRegistrar.setEnabled(false);
            vista5.btnEliminar.setEnabled(false);
            vista5.btnActualizar.setEnabled(true);
            int fila=vista5.tbPedido.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista5, "Debe seleccionar una fila");
        }else{
            int id=Integer.parseInt((String)vista5.tbPedido.getValueAt(fila, 0).toString());
            String codigo= (String)vista5.tbPedido.getValueAt(fila, 1);
            int cliente= Integer.parseInt((String)vista5.tbPedido.getValueAt(fila, 2).toString());
            int producto= Integer.parseInt((String)vista5.tbPedido.getValueAt(fila, 3).toString());
            double cantidad= Double.parseDouble((String)vista5.tbPedido.getValueAt(fila, 4).toString());
            String fecha= (String)vista5.tbPedido.getValueAt(fila, 5);
            
            vista5.txtCod.setText(codigo);
            vista5.txtIdCliente.setText(cliente+"");
            vista5.txtIdProducto.setText(producto+"");
            vista5.txtCantidad.setText(cantidad+"");
            vista5.txtFecha.setText(fecha);
        }
        }
        if(e.getSource()==vista5.btnActualizar){
            actualizarPedido();
            limpiarTablaPedido();
            listarPedido(vista5.tbPedido);
            limpiarCajasPedido();
            vista5.btnActualizar.setEnabled(false);
            vista5.btnEliminar.setEnabled(true);      
        }
        if(e.getSource()==vista5.btnEliminar){
            eliminarPedido();
            limpiarTablaPedido();
            listarPedido(vista5.tbPedido);
        }
        if(e.getSource()==vista5.btnNuevo){
            limpiarCajasPedido();
            vista5.btnRegistrar.setEnabled(true); 
            vista5.btnActualizar.setEnabled(false);
            vista5.btnEliminar.setEnabled(true);    
        }
    }
    
    private void eliminarPedido(){
        int fila =vista5.tbPedido.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista5, "Debe seleccionar una fila!!");
        }else{
            int id=Integer.parseInt((String)vista5.tbPedido.getValueAt(fila,0).toString());
            this.dao.eliminarPedido(id);
            JOptionPane.showMessageDialog(vista5, "Pedido eliminado");
        }
    } 

    private void actualizarPedido(){
        String codigo= vista5.txtCod.getText();
        int cliente= Integer.parseInt(vista5.txtIdCliente.getText());
        int producto=Integer.parseInt(vista5.txtIdProducto.getText());
        double cantidad= Double.parseDouble(vista5.txtCantidad.getText());
        String fecha= vista5.txtFecha.getText();
        
        if(codigo.equals("")||cliente<=0||producto<=0||cantidad<=0||fecha.equals("")){
            JOptionPane.showMessageDialog(vista5, "Debe llenar todos los campos");
        }else{
             Pedido inventario=new Pedido(codigo, cliente, producto, cantidad, fecha);
             int r= this.dao.actualizarPedido(inventario);
             if(r==1){
                 JOptionPane.showMessageDialog(vista5, "Cliente actualizado con exito...");
             }else{
                 JOptionPane.showMessageDialog(vista5, "Error al actualizar cliente!!!");
             }
        } 
    }
     
    private void agregarPedido(){
        String codigo= vista5.txtCod.getText();
        int cliente= Integer.parseInt(vista5.txtIdCliente.getText());
        int producto=Integer.parseInt(vista5.txtIdProducto.getText());
        double cantidad= Double.parseDouble(vista5.txtCantidad.getText());
        String fecha= vista5.txtFecha.getText();
        if(codigo.equals("")||cliente<=0||producto<=0||cantidad<=0||fecha.equals("")){
            JOptionPane.showMessageDialog(vista5, "Debe llenar todos los campos");
        }else{
            Pedido inventario=new Pedido(codigo, cliente, producto, cantidad, fecha);
            int r= this.dao.agregarPedido(inventario);
        if(r==1){
            JOptionPane.showMessageDialog(vista5, "Pedido agregado con exito...");
        }else{
            JOptionPane.showMessageDialog(vista5, "Error al agregar pedido!!!");
        }
        } 
    }
    
    private void listarPedido(JTable tabla){
        this.modeloTabla5=(DefaultTableModel)tabla.getModel();
        List<Pedido>listaInventario=this.dao.listarPedido();
        Object[] objeto=new Object[6];
        for(int i=0;i<listaInventario.size();i++){
            objeto[0]=listaInventario.get(i).getId();
            objeto[1]=listaInventario.get(i).getCodigo();
            objeto[2]=listaInventario.get(i).getCliente();
            objeto[3]=listaInventario.get(i).getProducto();
            objeto[4]=listaInventario.get(i).getCantidad();
            objeto[5]=listaInventario.get(i).getFecha();
            modeloTabla5.addRow(objeto);  
        }
        vista5.tbPedido.setModel(modeloTabla5);
    }

    private void limpiarTablaPedido(){
        for(int i=0;i<vista5.tbPedido.getRowCount();i++){
            modeloTabla5.removeRow(i);
            i=i-1;
        }
    }
    
    private void limpiarCajasPedido(){
        vista5.txtCod.setText("");
        vista5.txtCantidad.setText("");
        vista5.txtCodProducto.setText("");
        vista5.txtFecha.setText("");
        vista5.txtDniCliente.setText("");
        vista5.txtIdCliente.setText("");
        vista5.txtIdProducto.setText("");
    }
  
}
