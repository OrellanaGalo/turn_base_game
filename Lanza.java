public class Lanza extends Arma{
    private Personaje personaje;

    protected Lanza(String nombre, float ataque, float condicion) {
        super(nombre, ataque, condicion);
    }

    @Override
    public float modificarStat() {
        if(ataque >= 0){
            return personaje.ataque = personaje.ataque + ataque;
        }

        return personaje.ataque;
    }

    @Override
    public String aCadena() {
        return "[" + nombre + "//" + ataque + "]";
    }
}
