import
import javax.swing.table.DefaulTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private Biblioteca biblioteca;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtCodigo;
    private JTextField txtGenero;
    private JTextField txtAnio;
    private JTextField txtCopias;

    private JTextField txtBuscarAutor;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JButton btnAgregar;
    private JButton getBtnAgregarFiltrar;
    private JButton btnMostrarTodos;
    private JButton btnEliminar;

    public VentanaPrincipal(){
        biblioteca=new Biblioteca();
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(900, 600);

    private JButton btnFiltrar;
    private JButton btnMostrarTodos;
    private JButton btnEliminar;

    public VentanaPrincipal() {
        biblioteca = new Biblioteca();
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal=new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        JPanel panelFormulario=new JPanel();

        panelFormulario.setLayout(new GridLayout(3, 4, 5, 5));

        txtTitulo=new JTextField();
        txtAutor=new JTextField();
        txtCodigo=new JTextField();
        txtGenero=new JTextField();
        txtAnio=new JTextField();
        txtCopias=new JTextField();

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 4, 5, 5));

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtCodigo = new JTextField();
        txtGenero = new JTextField();
        txtAnio = new JTextField();
        txtCopias = new JTextField();

        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Autor:"));
        panelFormulario.add(txtAutor);

        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);

        panelFormulario.add(new JLabel("Género:"));
        panelFormulario.add(txtGenero);

        panelFormulario.add(new JLabel("Año:"));
        panelFormulario.add(txtAnio):

        panelFormulario.add(new JLabel("Copias:"));
        panelFormulario.add(txtCopias);

        JPanel panelBotones = new JPanel();

        btnAgregar = new JButton(("Agregar libro"));
        btnFiltrar = new JButton("Filtrar por autor");
        btnMostrarTodos = new JButton("Mostrar todos");
        btnEliminar = new JButton("Eliminar");

        JPanel panelBusqueda = new JPanel();
        txtBuscarAutor = new JTextField(15);

        panelBusqueda.add(new JLabel("Buscar autor."));
        panelBusqueda.add(txtBuscarAutor);

        String[] columnas = {
                "Título",
                "Autor",
                "Código",
                "Género",
                "Año",
                "Copias"};

        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelSuperior = new Jpanel(new BorderLayout());

        panelSuperior.add(panelFormulario,BorderLayout.CENTER);

        panelSuperior.add(panelBusqueda,BorderLayout.SOUTH);

        panelPrincipal.add(panelSuperior,BorderLayout.NORTH);

        panelPrincipal.add(scroll,BorderLayout.CENTER);


        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelFormulario,BorderLayout.CENTER);
        panelSuperior.add(panelBusqueda,BorderLayout.SOUTH);

        panelPrincipal.add(panelSuperior,BorderLayout.NORTH);
        panelPrincipal.add(scroll,BorderLayout.CENTER);

        panelPrincipal.add(panelBusqueda,BorderLayout.SOUTH);
        add(panelPrincipal);

        btnAgregar.addActionListener(new ActionListener() {

            public  void actionPerformed(ActionEvent e){
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarLibros();
            }
        });

        btnMostrarTodos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

        btnMostrarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });

        btnEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
    }

    private void agregarLibro(){

    private void agregarLibro() {

        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String codigo = txtCodigo.getText().trim();
        String genero = txtGenero.getText().trim();
        String anioTexto = txtAnio.getText().trim();
        String copiasTexto = txtCopias.getText().trim();


        if (titulo.isEmpty()||
        autor.isEmpty()||codigo.isEmpty()||
        genero.isEmpty()||
        anioTexto.isEmpty()||
        copiasText.isEmpty()) {


        if (titulo.isEmpty()||autor.isEmpty()||codigo.isEmpty()||genero.isEmpty()||anioTexto.isEmpty()||copiasTexto.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        int anio;
        int copias;

        try {
            anio = Integer.parseInt(anioTexto);
            copias = Integer.parseInt(copiasTexto);

        }catch (NumberFormatException e){

            JOptionPane.showMessageDialog(this, "El año y las copias deben ser números.");
            return;
        }

        if (anio <= 0 || copias < 0){
            JOptionPane.showMessageDialog(this, "El año debe ser válido y las copias no pueden ser negativas.");
            return;
        }
        Libro libro = new Libro(titulo, autor, codigo, genero, anio, copias);

        if (biblioteca.agregarLibro(libro)){

        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año y las copias deben ser números.");
            return;
        }
        if (anio <= 0 || copias < 0) {
            JOptionPane.showMessageDialog(this, "El año debe ser válido y las copias no pueden ser negativas.");
            return;
        }

        Libro libro = new Libro(titulo, autor, codigo, genero, anio, copias);
        if (biblioteca.agregarLibro(libro)) {

            JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
            limpiarCampos();
            mostrarTodos();
        }else {
            JOptionPane.showMessageDialog(this, "Ya existe un libro con ese código.");
        }
    }

    private void filtrarLibros() {
        String autor = txtBuscarAutor.getText().trim();


        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba un actor para realizar la búsqueda.");

        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba un autor para realizar la búsqueda.");
            return;
        }
        ArrayList<Libro> librosEncontrados = biblioteca.filtrarPorAutor(autor);
        actualizarTabla(librosEncontrados);
    }

    private void actualizarTabla(ArrayList<Libro> libros){
        modeloTabla.setRowCount(0);

        for (Libro libro : libros){

    private void actualizarTabla(ArrayList<Libro> libros) {
        modeloTabla.setRowCount(0);
        for (Libro libro : libros) {

            Object[] fila = {
                    libro.getTitulo(),
                    Libro.getAutor(),
                    Libro.getCodigo(),
                    Libro.getGenero(),
                    Libro.getAnioPublicacion(),
                    Libro.getCopiasDisponibles()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void eliminarLibro(){
        int filaSeleccionada=tabla.getSelectedRow();

        if (filaSeleccionada == -1){
            JOptinPane.showMessageDialog(this, "Seleccione un libro de la tabla.");
            return;
        }
        String codigo = modeloTabla.getValueAt(filaSeleccionada, 2).toString();
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está segur@ de eliminar este libro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_NO_OPTION){

    private void eliminarLibro() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro de la tabla.");
            return;
        }
        String codigo = modeloTabla.getValueAt(filaSeleccionada, 2).toString();
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este libro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_NO_OPTION) {
            if (biblioteca.eliminartLibro(codigo) {

                JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");
                mostrarTodos();
            }
        }
    }

    private void limpiarCampos(){

    private void limpiarCampos() {

        txtTitulo.setText("");
        txtAutor.setText("");
        txtCodigo.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
        txtCopias.setText("");
    }
}
