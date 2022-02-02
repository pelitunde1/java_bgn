package harmadik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FajlMod
{

    public  List<String>  FajlOlv (Path path) //void helyett lista itt is
    {
        try {
            List<String> lista = Files.readAllLines(path);  //bármely files metódus kivételt dobhat
            return lista;
            /*for (String s : lista)
            {   System.out.println("lista: " + s); }
            */
        } catch (IOException ioe) {
            throw new IllegalStateException("nem jó, ", ioe);
        }
    }

    public void FajlIr (Path path) {
        List<String> lista2 = FajlOlv(Path.of("src\\main\\resources\\bevaslista")); // beolvasós
        try {
            lista2.add("alma :D");
            lista2.add("szappan");
            Files.write(path, lista2);
        } catch (IOException ioe) {
            throw new IllegalStateException("Nemtom", ioe);
        }
    }


    public static void main(String[] args) {
        FajlMod r = new FajlMod();
        Path path= Path.of("src\\main\\resources\\bevaslista2");    //ide ír ki
        r.FajlIr(path); // ide kell az írós
        //????
    }

}
