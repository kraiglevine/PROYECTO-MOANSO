
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.InventarioDAO;
import models.Cliente;
import views.Cliente_Principal;
import views.Pedido_Principal;

public class ClienteController implements ActionListener{
    DefaultTableModel modeloTabla4=new DefaultTableModel();
    Cliente_Principal vista4=new Cliente_Principal();
    Pedido_Principal view=new Pedido_Principal();
    InventarioDAO dao=new InventarioDAO();
    
    
    public ClienteController(Cliente_Principal cliente){
        this.vista4=cliente;
        this.vista4.btnListar.addActionListener(this);
        this.vista4.btnRegistrar.addActionListener(this);
        this.vista4.btnNuevo.addActionListener(this);
        this.vista4.btnEditar.addActionListener(this);
        this.vista4.btnEliminar.addActionListener(this);
        this.vista4.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==vista4.btnListar){
            limpiarTablaCliente();
            listarCliente(vista4.tbClientes);           
        }
        
        if(e.getSource()==vista4.btnRegistrar){
            agregarCliente();
            limpiarCajasCliente();
            limpiarTablaCliente();
            listarCliente(vista4.tbClientes);
        }
        if(e.getSource()==vista4.btnEditar){
            vista4.btnRegistrar.setEnabled(false);
            vista4.btnEliminar.setEnabled(false);
            vista4.btnActualizar.setEnabled(true);
            int fila=vista4.tbClientes.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista4, "Debe selecionar una fila...");
        }else{
            int id= Integer.parseInt((String)vista4.tbClientes.getValueAt(fila, 0).toString());
            String nombres= (String)vista4.tbClientes.getValueAt(fila,1);
            String apellidos=(String)vista4.tbClientes.getValueAt(fila,2);
            String dni=(String)vista4.tbClientes.getValueAt(fila,3);
            String correo=(String)vista4.tbClientes.getValueAt(fila, 4);
            String telefono=(String)vista4.tbClientes.getValueAt(fila, 5);

            vista4.txtNombres.setText(nombres);
            vista4.txtApellidos.setText(apellidos);
            vista4.txtDNI.setText(dni);
            vista4.txtCorreo.setText(correo);
            vista4.txtCelular.setText(telefono);
            }    
        }
        if(e.getSource()==vista4.btnActualizar){
            actualizarCliente();
            limpiarTablaCliente();
            listarCliente(vista4.tbClientes);
            limpiarCajasCliente();
            vista4.btnActualizar.setEnabled(false);
            vista4.btnEliminar.setEnabled(true);      
        }
        if(e.getSource()==vista4.btnEliminar){
            eliminarCliente();
            limpiarTablaCliente();
            listarCliente(vista4.tbClientes);
        }
        if(e.getSource()==vista4.btnNuevo){
            limpiarCajasCliente();
            vista4.btnRegistrar.setEnabled(true); 
            vista4.btnActualizar.setEnabled(false);
            vista4.btnEliminar.setEnabled(true);    
        }
         
    }
    
    private void eliminarCliente(){
        int fila =vista4.tbClientes.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista4, "Debe seleccionar una fila!!");
        }else{
            int id=Integer.parseInt((String)vista4.tbClientes.getValueAt(fila,0).toString());
            this.dao.eliminarCliente(id);
            JOptionPane.showMessageDialog(vista4, "Cliente eliminado");
        }
    } 

    private void actualizarCliente(){
         String nombres= (String)vista4.txtNombres.getText();
         String apellidos=(String)vista4.txtApellidos.getText();
         String dni=(String)vista4.txtDNI.getText();
         String correo=(String)vista4.txtCorreo.getText();
         String telefono= (String)vista4.txtCelular.getText();
        
        if(nombres.equals("")||apellidos.equals("")||dni.equals("")||correo.equals("")||telefono.equals("")){
            JOptionPane.showMessageDialog(vista4, "Debe llenar todos los campos");
        }else{
             Cliente inventario=new Cliente(nombres, apellidos, dni, correo, telefono);
             int r= this.dao.actualizarCliente(inventario);
             if(r==1){
                 JOptionPane.showMessageDialog(vista4, "Cliente actualizado con exito...");
             }else{
                 JOptionPane.showMessageDialog(vista4, "Error al actualizar cliente!!!");
             }
        } 
    }
     
    private void agregarCliente(){
        String nombres= (String)vista4.txtNombres.getText();
        String apellidos=(String)vista4.txtApellidos.getText();
        String dni=(String)vista4.txtDNI.getText();
        String correo=(String)vista4.txtCorreo.getText();
        String telefono= (String)vista4.txtCelular.getText();
        if(nombres.equals("")||apellidos.equals("")||dni.equals("")||correo.equals("")||telefono.equals("")){
            JOptionPane.showMessageDialog(vista4, "Debe llenar todos los campos");
        }else{
            Cliente inventario=new Cliente(nombres, apellidos, dni, correo, telefono);
            int r= this.dao.agregarCliente(inventario);
        if(r==1){
            JOptionPane.showMessageDialog(vista4, "Cliente agregado con exito...");
        }else{
            JOptionPane.showMessageDialog(vista4, "Error al agregar cliente!!!");
        }
        } 
    }
    
    private void listarCliente(JTable tabla){
        this.modeloTabla4=(DefaultTableModel)tabla.getModel();
        List<Cliente>listaInventario=this.dao.listarCliente();
        Object[] objeto=new Object[6];
        for(int i=0;i<listaInventario.size();i++){
            objeto[0]=listaInventario.get(i).getId();
            objeto[1]=listaInventario.get(i).getNombre();
            objeto[2]=listaInventario.get(i).getApellido();
            objeto[3]=listaInventario.get(i).getDni();
            objeto[4]=listaInventario.get(i).getCorreo();
            objeto[5]=listaInventario.get(i).getTelefono();
            modeloTabla4.addRow(objeto);  
        }
        vista4.tbClientes.setModel(modeloTabla4);
    }

    private void limpiarTablaCliente(){
        for(int i=0;i<vista4.tbClientes.getRowCount();i++){
            modeloTabla4.removeRow(i);
            i=i-1;
        }
    }
    
    private void limpiarCajasCliente(){
        vista4.txtNombres.setText("");
        vista4.txtApellidos.setText("");
        vista4.txtDNI.setText("");
        vista4.txtCorreo.setText("");
        vista4.txtCelular.setText("");

    }
    
}
