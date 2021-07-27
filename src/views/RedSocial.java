package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RedSocial {

	protected Shell shell;
	private Text txtNombreVendedor;
	private Text txtNomProducto;
	private Text txtPrecioProd;

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
		
		Group grpAgregarVendedor = new Group(shell, SWT.NONE);
		grpAgregarVendedor.setText("Agregar Vendedor");
		grpAgregarVendedor.setBounds(373, 10, 318, 67);
		
		Label lblNombre = new Label(grpAgregarVendedor, SWT.NONE);
		lblNombre.setBounds(10, 31, 55, 15);
		lblNombre.setText("Nombre");
		
		txtNombreVendedor = new Text(grpAgregarVendedor, SWT.BORDER);
		txtNombreVendedor.setBounds(84, 31, 112, 21);
		
		Button btnAgregarVendedor = new Button(grpAgregarVendedor, SWT.NONE);
		btnAgregarVendedor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				
				
			}
		});
		btnAgregarVendedor.setBounds(213, 31, 75, 25);
		btnAgregarVendedor.setText("Agregar");
		
		Group grpAccionesVendedor = new Group(shell, SWT.NONE);
		grpAccionesVendedor.setText("Acciones Vendedor");
		grpAccionesVendedor.setBounds(373, 83, 316, 280);
		
		Group grpAgregarProductos = new Group(grpAccionesVendedor, SWT.NONE);
		grpAgregarProductos.setText("Agregar productos");
		grpAgregarProductos.setBounds(10, 81, 296, 101);
		
		Label lblNombre_1 = new Label(grpAgregarProductos, SWT.NONE);
		lblNombre_1.setBounds(10, 27, 44, 15);
		lblNombre_1.setText("Nombre");
		
		Label lblPrecio = new Label(grpAgregarProductos, SWT.NONE);
		lblPrecio.setBounds(10, 61, 44, 15);
		lblPrecio.setText("Precio");
		
		txtNomProducto = new Text(grpAgregarProductos, SWT.BORDER);
		txtNomProducto.setBounds(77, 24, 112, 21);
		
		txtPrecioProd = new Text(grpAgregarProductos, SWT.BORDER);
		txtPrecioProd.setBounds(77, 61, 112, 21);
		
		Button btnAgregarProd = new Button(grpAgregarProductos, SWT.NONE);
		btnAgregarProd.setBounds(211, 44, 75, 25);
		btnAgregarProd.setText("Agregar");
		
		Group grpConectar = new Group(grpAccionesVendedor, SWT.NONE);
		grpConectar.setText("Conectar");
		grpConectar.setBounds(10, 188, 296, 82);
		
		Label lblNombre_2 = new Label(grpConectar, SWT.NONE);
		lblNombre_2.setBounds(10, 37, 55, 15);
		lblNombre_2.setText("Nombre");
		
		Button btnConectar = new Button(grpConectar, SWT.NONE);
		btnConectar.setBounds(211, 32, 75, 25);
		btnConectar.setText("Conectar");
		
		Combo comboNomVend2 = new Combo(grpConectar, SWT.NONE);
		comboNomVend2.setBounds(76, 34, 112, 23);
		
		Label lblVendedor = new Label(grpAccionesVendedor, SWT.NONE);
		lblVendedor.setBounds(20, 35, 55, 15);
		lblVendedor.setText("Vendedor");
		
		Combo comboBoxNomVend = new Combo(grpAccionesVendedor, SWT.NONE);
		comboBoxNomVend.setBounds(87, 35, 112, 23);
		
		Group grpEstadisticas = new Group(shell, SWT.NONE);
		grpEstadisticas.setText("Estadisticas");
		grpEstadisticas.setBounds(373, 369, 318, 130);

	}
}
