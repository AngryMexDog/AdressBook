import java.io.*;
import java.util.HashMap;
import java.util.Map;

public final class AdminAgenda {

    //generacion de un objeto hasmap llamado myContact
    HashMap <String, String> myContact = new HashMap<>();
    String[] arrayContacto;  //arrray de nombre arrayContacto

    //direcciones donde se guardaron los archivos
    String inputFilename = "src/input.csv";
    String outputFilename = "src/output.csv";


    public void cargarContactoFile(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        //hacer try-catch para checar excepciones
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilename));
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            String line;

            //guardar datos en las celdas del array 0 y 1
            //en el csv sería columnas A y B
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                arrayContacto = line.split(",");
                myContact.put(arrayContacto[0],arrayContacto[1]);
            }
        } catch (Exception e){//permitimos que el sistema indique cual es el problema
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (bufferedReader != null){
                    bufferedWriter.close();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    //ciclo for que recorre todos los elementos en myContact - para ver cada elemento
    public void mostrar(){
        for (Map.Entry<String,String> entry: myContact.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            //despliega la key y el valor
            System.out.println("Listado");
            System.out.println(key + " " + value);
        }
    }

    //metodo para agregar contacto
    public void addContacto(){
        System.out.println("Metodo addContacto");
        myContact.put("345678", "Maria Isabel aLLENDE");
    }

    public void actualizarContactosFile(){
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            String line;//se recorre todo el array
            for (Map.Entry<String,String> entry : myContact.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();

                line = key + "," + value;
                //se escribe la linea que queremos que salga en el archivo de salida
                bufferedWriter.write(line + "\n");

            }
        }
        catch (IOException e){ //catch si hay error
            System.out.println(e.getMessage());
        }
        finally {
            try{
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}