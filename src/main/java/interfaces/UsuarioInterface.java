package interfaces;


import java.util.ArrayList;

import models.Usuario;

public interface UsuarioInterface {
	public Usuario validarAcceso(String usuario,String clave);

	public int registrar(Usuario u);
	public int actualizar(Usuario u);
	public int eliminar(int cod);
	public Usuario listarCodigo(int cod);
	public ArrayList<Usuario> listado();
	public ArrayList<Usuario> reportListado();
	public Usuario buscar(int codigo);

}
