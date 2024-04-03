abstract class Bloque {
    private static int id_count = 0;
    protected int id;
    
    public Bloque(){
        this.id = id_count;
        id_count ++;
    }

    public int getId(){
        return this.id;
    }
}
