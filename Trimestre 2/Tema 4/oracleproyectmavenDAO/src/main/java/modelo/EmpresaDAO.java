package modelo;

import java.util.List;
import modelo.Empresa;

public interface EmpresaDAO {
    void agregarEmpresa(Empresa empresa);
    void actualizarEmpresa(Empresa empresa);
    void eliminarEmpresa(int id);
    Empresa obtenerEmpresa(int id);
    List<Empresa> obtenerTodasLasEmpresas();
}
