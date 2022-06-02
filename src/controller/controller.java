/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.methods;
import model.user;
import view.authentication.LoginJFrame;
import view.authentication.RegisterJFrame;

/**
 *
 * @author eslim
 */
public class controller implements ActionListener {

    //Models
    methods method = new methods();
    user user = new user();
    //Views
    LoginJFrame login = new LoginJFrame();
    RegisterJFrame register = new RegisterJFrame();
    
    public controller(RegisterJFrame register, user user){
        this.register = register;
        this.user = user;
        
        //Registro de Usuarios
        this.register.RegisterDataButton.addActionListener(this);
    }
    
    //Metodo Registrar
    public void Register(){
        user.setFirstname(register.FirstNameTextField.getText());
        user.setLastname(register.LastNameTextField.getText());
        user.setEmail(register.EmailTextField.getText());
        user.setUsername(register.UsernameTextField.getText());
        user.setPassword(register.PasswordField.getText());
        
        if(method.InsertUser(user)){
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el usuario");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register.RegisterDataButton){
            Register();
        }
    }
    
}
 