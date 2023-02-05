package Modelos_clases;

public class Municipio {
    private String mNombre;
    private String mCodigo;

    public Municipio(){}

    public Municipio(String nombre, String codigo){
        this.mNombre = nombre;
        this.mCodigo = codigo;
    }

    public String getmNombre() {
        return mNombre;
    }

    public void setmNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    public String getmCodigo() {
        return mCodigo;
    }

    public void setmCodigo(String mCodigo) {
        this.mCodigo = mCodigo;
    }
}
