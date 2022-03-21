public class AgendaTelefonica_Main {

    //se crea una clase de objeto AdminAgenda
    static AdminAgenda contactos = new AdminAgenda();

    //ejecutamos el objeto
    public static void main(String[] args) {
        contactos.cargarContactoFile();
        contactos.mostrar();
        contactos.addContacto();
        contactos.mostrar();
        contactos.actualizarContactosFile();
    }
}
