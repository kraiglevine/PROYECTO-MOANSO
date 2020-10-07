package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.InventarioDAO;
import models.Usuario;
import views.Usuario_Principal;

public class UsuarioController implements ActionListener {
    DefaultTableModel modeloTabla2=new DefaultTableModel();
    Usuario_Principal vista2=new Usuario_Principal();
    InventarioDAO dao=new InventarioDAO();
    public UsuarioController(Usuario_Principal usuario){
        this.vista2=usuario;
        this.vista2.btnListar.addActionListener(this);
        this.vista2.btnRegistrar.addActionListener(this);
        this.vista2.btnNuevo.addActionListener(this);
        this.vista2.btnEditar.addActionListener(this);
        this.vista2.btnEliminar.addActionListener(this); 
        this.vista2.btnActualizar.addActionListener(this);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==vista2.btnListar){
            limpiarTablaUsuario();
            listarUsuario(vista2.tbUsuarios);
        }
        
        if(e.getSource()==vista2.btnRegistrar){
            agregarUsuario();
            limpiarCajasUsuario();
            limpiarTablaUsuario();
            listarUsuario(vista2.tbUsuarios);
        }
        if(e.getSource()==vista2.btnEditar){
            vista2.btnRegistrar.setEnabled(false);
            vista2.btnEliminar.setEnabled(false);
            vista2.btnActualizar.setEnabled(true);
            int fila=vista2.tbUsuarios.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista2, "Debe selecionar una fila...");
        }else{
            int id= Integer.parseInt((String)vista2.tbUsuarios.getValueAt(fila, 0).toString());
            String nombres= (String)vista2.tbUsuarios.getValueAt(fila,1);
            String apellidos=(String)vista2.tbUsuarios.getValueAt(fila,2);
            String dni=(String)vista2.tbUsuarios.getValueAt(fila,3);
            String contraseña=(String)vista2.tbUsuarios.getValueAt(fila, 4);
            String tipo=(String)vista2.tbUsuarios.getValueAt(fila, 5);

            vista2.txtNombres.setText(nombres);
            vista2.txtApellidos.setText(apellidos);
            vista2.txtDNI.setText(dni);
            vista2.txtContraseña.setText(contraseña);
            vista2.txtTipo.setText(tipo);
            }
        }
        if(e.getSource()==vista2.btnActualizar){
            actualizarUsuario();
            limpiarTablaUsuario();
            listarUsuario(vista2.tbUsuarios);
            limpiarCajasUsuario();
            vista2.btnActualizar.setEnabled(false);
            vista2.btnEliminar.setEnabled(true);      
        }
         if(e.getSource()==vista2.btnEliminar){
            eliminarUsuario();
            limpiarTablaUsuario();
            listarUsuario(vista2.tbUsuarios);
        }
        if(e.getSource()==vista2.btnNuevo){
            limpiarCajasUsuario();
            vista2.btnRegistrar.setEnabled(true); 
            vista2.btnActualizar.setEnabled(false);
            vista2.btnEliminar.setEnabled(true);    
        }
    }
    
  
     private void eliminarUsuario(){
        int fila =vista2.tbUsuarios.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista2, "Debe seleccionar una fila!!");
        }else{
            int id=Integer.parseInt((String)vista2.tbUsuarios.getValueAt(fila,0).toString());
            this.dao.eliminarUsuario(id);
            JOptionPane.showMessageDialog(vista2, "Producto eliminado");
        }
    } 

     private void actualizarUsuario(){
         String nombres= (String)vista2.txtNombres.getText();
         String apellidos=(String)vista2.txtApellidos.getText();
         String dni=(String)vista2.txtDNI.getText();
         String contraseña=(String)vista2.txtContraseña.getText();
         String tipo=(String)vista2.txtTipo.getText();
        
        if(nombres.equals("")||apellidos.equals("")||dni.equals("")||contraseña.equals("")||tipo.equals("")){
            JOptionPane.showMessageDialog(vista2, "Debe llenar todos los campos");
        }else{
             Usuario inventario=new Usuario(nombres, apellidos, dni, contraseña, tipo);
             int r= this.dao.actualizarUsuario(inventario);
             if(r==1){
                 JOptionPane.showMessageDialog(vista2, "Producto actualizado con exito...");
             }else{
                 JOptionPane.showMessageDialog(vista2, "Error al actualizar producto!!!");
             }
        } 
    }
    private void agregarUsuario(){
        String nombres= (String)vista2.txtNombres.getText();
        String apellidos=(String)vista2.txtApellidos.getText();
        String dni=(String)vista2.txtDNI.getText();
        String contraseña=(String)vista2.txtContraseña.getText();
        String tipo=(String)vista2.txtTipo.getText();
        if(nombres.equals("")||apellidos.equals("")||dni.equals("")||contraseña.equals("")||tipo.equals("")){
            JOptionPane.showMessageDialog(vista2, "Debe llenar todos los campos");
        }else{
            
            Usuario inventario=new Usuario(nombres, apellidos, dni, contraseña, tipo);
            int r= this.dao.agregarUsuario(inventario);
        if(r==1){
            JOptionPane.showMessageDialog(vista2, "Producto agregado con exito...");
        }else{
            JOptionPane.showMessageDialog(vista2, "Error al agregar producto!!!");
        }
        } 
    }
    private void listarUsuario(JTable tabla){
        this.modeloTabla2=(DefaultTableModel)tabla.getModel();
        List<Usuario>listaInventario=this.dao.listarUsuario();
        Object[] objeto=new Object[6];
        for(int i=0;i<listaInventario.size();i++){
            objeto[0]=listaInventario.get(i).getId();
            objeto[1]=listaInventario.get(i).getNombres();
            objeto[2]=listaInventario.get(i).getApellidos();
            objeto[3]=listaInventario.get(i).getDni();
            objeto[4]=listaInventario.get(i).getContraseña();
            objeto[5]=listaInventario.get(i).getTipo();
            modeloTabla2.addRow(objeto);  
        }
        vista2.tbUsuarios.setModel(modeloTabla2);
    }

    private void limpiarTablaUsuario(){
        for(int i=0;i<vista2.tbUsuarios.getRowCount();i++){
            modeloTabla2.removeRow(i);
            i=i-1;
        }
    }
    
    private void limpiarCajasUsuario(){
        vista2.txtNombres.setText("");
        vista2.txtApellidos.setText("");
        vista2.txtDNI.setText("");
        vista2.txtContraseña.setText("");
        vista2.txtTipo.setText("");

    }
    
}
 


