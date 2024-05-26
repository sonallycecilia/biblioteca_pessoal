package database.mysql.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import classes.entities.Usuario;
import database.mysql.conexaoDB.ConexaoUsuario;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = ConexaoUsuario.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
