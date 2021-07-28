package views;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import ModelFactoryController.RedSocialController;
import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;
import modelo.NodoGrafo;
import modelo.Producto;
import modelo.Vendedor;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.viewers.ComboViewer;

public class RedSocial {

	protected Shell shell;
	private Text txtNombreNuevoVend;
	private Text txtNombreProd;
	private Text txtCategoria;
	private Button button; 
	private Button btnAgregar;
	
	private int vendedores = 0;
	private String vendedorSeleccionado = "";
	private String vendedorConectar = "";
	
	private HashMap<String,NodoGrafo> lista;
	private RedSocialController controller = new RedSocialController();
	private Combo comboVend;
	private Text txtClave;
	private Combo comboVendConect;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RedSocial window = new RedSocial();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(717, 538);
		shell.setText("SWT Application");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(0, 0, 701, 499);
		
		TabItem tbtmConfiguracion = new TabItem(tabFolder, SWT.NONE);
		tbtmConfiguracion.setText("Configuracion");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmConfiguracion.setControl(composite);
		
		Group group = new Group(composite, SWT.NONE);
		group.setText("Agregar Vendedor");
		group.setBounds(375, 10, 318, 94);
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Nombre");
		label.setBounds(10, 31, 55, 15);
		
		txtNombreNuevoVend = new Text(group, SWT.BORDER);
		txtNombreNuevoVend.setBounds(84, 31, 112, 21);
		
		Group group_1 = new Group(composite, SWT.NONE);
		group_1.setText("Acciones Vendedor");
		group_1.setBounds(375, 110, 316, 253);
		
		Group group_2 = new Group(group_1, SWT.NONE);
		group_2.setText("Agregar productos");
		group_2.setBounds(10, 55, 296, 101);
		
		Label label_1 = new Label(group_2, SWT.NONE);
		label_1.setText("Nombre");
		label_1.setBounds(10, 27, 44, 15);
		
		Label lblCategoria = new Label(group_2, SWT.NONE);
		lblCategoria.setText("Categoria");
		lblCategoria.setBounds(10, 61, 51, 15);
		
		txtNombreProd = new Text(group_2, SWT.BORDER);
		txtNombreProd.setBounds(77, 24, 112, 21);
		
		txtCategoria = new Text(group_2, SWT.BORDER);
		txtCategoria.setBounds(77, 61, 112, 21);
		
		Button btnAgregarProd = new Button(group_2, SWT.NONE);
		btnAgregarProd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				if(!vendedorSeleccionado.equalsIgnoreCase("")){
					if(!txtNombreProd.getText().equalsIgnoreCase("") && !txtCategoria.getText().equalsIgnoreCase("")){
						Producto p = new Producto(txtNombreProd.getText(), txtCategoria.getText());
			            if(controller.agregarProdVendedor(vendedorSeleccionado,p)){
			            	JOptionPane.showMessageDialog(null, "producto agregado con exito.");
			            }else{
			            	JOptionPane.showMessageDialog(null, "el producto ya existe o el vendedor no existe.");
			            }
					}else{
						JOptionPane.showMessageDialog(null, "debe ingresar el nombre del producto y la categoria.");
					}
				}else{
					
				}
			}
		});
		btnAgregarProd.setText("Agregar");
		btnAgregarProd.setBounds(211, 44, 75, 25);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Conectar");
		group_3.setBounds(10, 162, 296, 82);
		
		Label label_3 = new Label(group_3, SWT.NONE);
		label_3.setText("Nombre");
		label_3.setBounds(10, 37, 55, 15);
		
		Button btnConectar = new Button(group_3, SWT.NONE);
		btnConectar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!vendedorConectar.equalsIgnoreCase("") && !vendedorSeleccionado.equalsIgnoreCase("")){
					
					if(vendedorConectar.equalsIgnoreCase(vendedorSeleccionado)){
						JOptionPane.showMessageDialog(null, "no puede conectar un vendedor con el mismo");
					}else{
						
						Vendedor vendOrigen =  (Vendedor) controller.obtenerVendedor(vendedorSeleccionado);
						Vendedor vendDestino = (Vendedor) controller.obtenerVendedor(vendedorConectar); 
						if(vendDestino !=null ||vendOrigen  !=null){
							try {
								controller.conectarVendedores(vendOrigen,vendDestino);
							} catch (ErrorNodoNoExiste e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else{
							JOptionPane.showMessageDialog(null, "uno de los vendedores no existe");
						}
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "debe seleccionar vendedores para conectar");
				}
			}
		});
		btnConectar.setText("Conectar");
		btnConectar.setBounds(211, 32, 75, 25);
		
		comboVendConect = new Combo(group_3, SWT.NONE);
		comboVendConect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int indice = comboVendConect.getSelectionIndex();
				vendedorConectar = comboVendConect.getItem(indice).toString();
			}
		});
		comboVendConect.setBounds(76, 34, 112, 23);
		
		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setText("Vendedor");
		label_4.setBounds(20, 29, 55, 15);
		
		ComboViewer comboViewer = new ComboViewer(group_1, SWT.NONE);
		comboVend = comboViewer.getCombo();
		comboVend.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int indice = comboVend.getSelectionIndex();
				vendedorSeleccionado = comboVend.getItem(indice).toString();
			}
		});
		comboVend.setBounds(83, 26, 112, 23);
		
		Group group_4 = new Group(composite, SWT.NONE);
		group_4.setText("Estadisticas");
		group_4.setBounds(375, 369, 318, 92);
		
		Button button = new Button(group, SWT.NONE);
		
		btnAgregar = new Button(group, SWT.NONE);
		btnAgregar.setText("Agregar");
		btnAgregar.setBounds(213, 43, 75, 25);
		
		Label lblClave = new Label(group, SWT.NONE);
		lblClave.setBounds(10, 69, 55, 15);
		lblClave.setText("Clave");
		
		txtClave = new Text(group, SWT.BORDER);
		txtClave.setBounds(84, 69, 112, 21);
		btnAgregar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(!txtNombreNuevoVend.getText().equalsIgnoreCase("") && !txtClave.getText().equalsIgnoreCase("")){
					
					TabItem tab_vendedor = new TabItem(tabFolder, SWT.NONE);
					tab_vendedor.setText(txtNombreNuevoVend.getText());
					
					Composite compositeVendedor = new Plantilla(tabFolder, SWT.NONE);
					//Plantilla p = new Plantilla(compositeVendedor, SWT.NONE);
					
					tab_vendedor.setControl(compositeVendedor);
					lista = controller.getGrafoNoDirigido();
					
					
					try {
						Vendedor vendedor = new Vendedor(txtNombreNuevoVend.getText(),txtClave.getText());
						controller.crearVendedor(vendedor);
					} catch (ErrorNodoYaExiste e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					llenarCombos();
					
				}else{
					JOptionPane.showMessageDialog(null, "debe ingresar un nombre y la clave");
				}
				
			}
		});



	}
	
	private void llenarCombos(){
		
		comboVend.removeAll();
		comboVendConect.removeAll();
		// Definir Iterator para extraer o imprimir valores 
		for( Iterator it = lista.keySet().iterator(); it.hasNext();) { 
			
			String s = (String)it.next();
			String s1 = (String)lista.get(s).getVendedor().getNombre();
			comboVend.add(s1);
			comboVendConect.add(s1);
		}
	}
	
}
