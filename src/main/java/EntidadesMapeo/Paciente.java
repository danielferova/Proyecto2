/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesMapeo;

/**
 *
 * @author danielferova
 */
public class Paciente extends Usuario{
    //campos de la DB de la entidad Paciente
    private String sexo;
    private String birthPaciente;
    private String pesoP;
    private String sangreP;

    public Paciente(String idUsuario, String nombreUsuario, String dpiUsuario, String telefonoUsuario, String correoUsuario, String contraseñaUsuario, int tipoUsuario, 
            String sexo, String birthPaciente, String pesoP, String sangreP) {
        super(idUsuario, nombreUsuario, dpiUsuario, telefonoUsuario, correoUsuario, contraseñaUsuario, tipoUsuario);
        this.sexo = sexo;
        this.birthPaciente = birthPaciente;
        this.pesoP = pesoP;
        this.sangreP = sangreP;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBirthPaciente() {
        return birthPaciente;
    }

    public void setBirthPaciente(String birthPaciente) {
        this.birthPaciente = birthPaciente;
    }

    public String getPesoP() {
        return pesoP;
    }

    public void setPesoP(String pesoP) {
        this.pesoP = pesoP;
    }

    public String getSangreP() {
        return sangreP;
    }

    public void setSangreP(String sangreP) {
        this.sangreP = sangreP;
    }
    
    
  
    
    
    
}
