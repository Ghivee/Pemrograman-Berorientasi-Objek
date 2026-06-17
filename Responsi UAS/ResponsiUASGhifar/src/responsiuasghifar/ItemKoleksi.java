package responsiuasghifar;

import java.io.Serializable;

public abstract class ItemKoleksi implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String judul;

    public ItemKoleksi(String id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    public String getId() { return id; }
    public String getJudul() { return judul; }

    // Abstract method: memaksa kelas anak mendefinisikan cara tampil info sendiri
    public abstract void tampilkanInfo();
}