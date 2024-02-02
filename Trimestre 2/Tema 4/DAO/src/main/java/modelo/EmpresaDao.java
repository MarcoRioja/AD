package modelo;

import java.util.List;

public interface EmpresaDao {
    void agregarEmpresa(Empresa empresa);
    void actualizarEmpresa(Empresa empresa);
    void eliminarEmpresa(int id);
    Empresa obtenerEmpresa(int id);
    List<Empresa> obtenerTodasLasEmpresas();
}
