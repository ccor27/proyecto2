package views;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Composite;

public class RedSocial {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Button button; 

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
		group.setBounds(375, 10, 318, 67);
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Nombre");
		label.setBounds(10, 31, 55, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(84, 31, 112, 21);
		
		Group group_1 = new Group(composite, SWT.NONE);
		group_1.setText("Acciones Vendedor");
		group_1.setBounds(375, 83, 316, 280);
		
		Group group_2 = new Group(group_1, SWT.NONE);
		group_2.setText("Agregar productos");
		group_2.setBounds(10, 81, 296, 101);
		
		Label label_1 = new Label(group_2, SWT.NONE);
		label_1.setText("Nombre");
		label_1.setBounds(10, 27, 44, 15);
		
		Label label_2 = new Label(group_2, SWT.NONE);
		label_2.setText("Precio");
		label_2.setBounds(10, 61, 44, 15);
		
		text_1 = new Text(group_2, SWT.BORDER);
		text_1.setBounds(77, 24, 112, 21);
		
		text_2 = new Text(group_2, SWT.BORDER);
		text_2.setBounds(77, 61, 112, 21);
		
		Button button_1 = new Button(group_2, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1.setText("Agregar");
		button_1.setBounds(211, 44, 75, 25);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Conectar");
		group_3.setBounds(10, 188, 296, 82);
		
		Label label_3 = new Label(group_3, SWT.NONE);
		label_3.setText("Nombre");
		label_3.setBounds(10, 37, 55, 15);
		
		Button button_2 = new Button(group_3, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_2.setText("Conectar");
		button_2.setBounds(211, 32, 75, 25);
		
		Combo combo = new Combo(group_3, SWT.NONE);
		combo.setBounds(76, 34, 112, 23);
		
		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setText("Vendedor");
		label_4.setBounds(20, 35, 55, 15);
		
		Combo combo_1 = new Combo(group_1, SWT.NONE);
		combo_1.setBounds(87, 35, 112, 23);
		
		Group group_4 = new Group(composite, SWT.NONE);
		group_4.setText("Estadisticas");
		group_4.setBounds(375, 369, 318, 92);
		
		Button button = new Button(group, SWT.NONE);
		
		button = new Button(group, SWT.NONE);
		button.setBounds(212, 26, 75, 25);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				 Table table;
				 Text text;
				 Table table_1;
				
				TabItem tab_vendedor = new TabItem(tabFolder, SWT.NONE);
				tab_vendedor.setText("nombre");
				
				Composite compositeVendedor = new Composite(tabFolder,SWT.NONE);
				tab_vendedor.setControl(compositeVendedor);
				
				Group grpMuro = new Group(compositeVendedor, SWT.NONE);
				grpMuro.setText("Muro");
				grpMuro.setBounds(10, 195, 382, 329);
				
				
				TableViewer tableViewer = new TableViewer(grpMuro, SWT.BORDER | SWT.FULL_SELECTION);
				table = tableViewer.getTable();
				table.setLinesVisible(true);
				table.setHeaderVisible(true);
				table.setBounds(10, 22, 362, 297);
				
				TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tblclmnNombre = tableViewerColumn.getColumn();
				tblclmnNombre.setWidth(128);
				tblclmnNombre.setText("Producto");
				
				TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tblclmnFechaYHora = tableViewerColumn_1.getColumn();
				tblclmnFechaYHora.setWidth(127);
				tblclmnFechaYHora.setText("Fecha y hora");
				
				TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tblclmnPublicadoPor = tableViewerColumn_2.getColumn();
				tblclmnPublicadoPor.setWidth(103);
				tblclmnPublicadoPor.setText("Publicado por");
				
				Group grpComentariosYMe = new Group(compositeVendedor, SWT.NONE);
				grpComentariosYMe.setText("Comentarios y me gusta");
				grpComentariosYMe.setBounds(398, 195, 302, 329);
				
				Group grpContactos = new Group(compositeVendedor, SWT.NONE);
				grpContactos.setText("Contactos");
				grpContactos.setBounds(398, 10, 302, 179);
				
				TableViewer tableViewer_1 = new TableViewer(grpContactos, SWT.BORDER | SWT.FULL_SELECTION);
				table_1 = tableViewer_1.getTable();
				table_1.setLinesVisible(true);
				table_1.setHeaderVisible(true);
				table_1.setBounds(10, 25, 282, 144);
				
				TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
				TableColumn tblclmnNombreDelContacto = tableViewerColumn_3.getColumn();
				tblclmnNombreDelContacto.setWidth(277);
				tblclmnNombreDelContacto.setText("Nombre del contacto");
				
				Group grpVendedor = new Group(compositeVendedor, SWT.NONE);
				grpVendedor.setText("Vendedor");
				grpVendedor.setBounds(10, 10, 382, 179);
				
				Label lblNombreDelVendedor = new Label(grpVendedor, SWT.NONE);
				lblNombreDelVendedor.setBounds(10, 49, 47, 15);
				lblNombreDelVendedor.setText("Nombre ");
				
				text = new Text(grpVendedor, SWT.BORDER);
				text.setBounds(10, 70, 88, 21);
				
				Label lbl_IconoUsiario = new Label(grpVendedor, SWT.NONE);
				lbl_IconoUsiario.setImage(SWTResourceManager.getImage("C:\\estructuraDatos\\proyecto2\\resources\\iconoUsuario2.png"));
				lbl_IconoUsiario.setBounds(178, 23, 146, 133);
			}
		});



	}
}
