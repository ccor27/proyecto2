package views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Plantilla extends Composite {
	private Table tblProductos;
	private Text txtNombreVendedor;
	private Table tblContactos;
	private Text txtAreaComentMeg;
	private Text txtComentario;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Plantilla(Composite parent, int style) {
		super(parent, style);
		
		Group grpMuro = new Group(this, SWT.NONE);
		grpMuro.setText("Muro");
		grpMuro.setBounds(10, 195, 382, 265);
		
		TableViewer tableViewer = new TableViewer(grpMuro, SWT.BORDER | SWT.FULL_SELECTION);
		tblProductos = tableViewer.getTable();
		tblProductos.setLinesVisible(true);
		tblProductos.setHeaderVisible(true);
		tblProductos.setBounds(10, 22, 362, 229);
		
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
		
		Group grpComentariosYMe = new Group(this, SWT.NONE);
		grpComentariosYMe.setText("Comentarios y me gusta");
		grpComentariosYMe.setBounds(398, 195, 302, 265);
		
		txtAreaComentMeg = new Text(grpComentariosYMe, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		txtAreaComentMeg.setBounds(10, 32, 282, 157);
		
		txtComentario = new Text(grpComentariosYMe, SWT.BORDER);
		txtComentario.setBounds(10, 213, 101, 21);
		
		Button btnComentar = new Button(grpComentariosYMe, SWT.NONE);
		btnComentar.setBounds(129, 211, 75, 25);
		btnComentar.setText("Comentar");
		
		Button btnMeGusta = new Button(grpComentariosYMe, SWT.NONE);
		btnMeGusta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMeGusta.setBounds(217, 212, 75, 23);
		btnMeGusta.setText("Me gusta");
		
		Group grpContactos = new Group(this, SWT.NONE);
		grpContactos.setText("Contactos");
		grpContactos.setBounds(398, 10, 302, 179);
		
		TableViewer tableViewer_1 = new TableViewer(grpContactos, SWT.BORDER | SWT.FULL_SELECTION);
		tblContactos = tableViewer_1.getTable();
		tblContactos.setLinesVisible(true);
		tblContactos.setHeaderVisible(true);
		tblContactos.setBounds(10, 25, 282, 144);
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnNombreDelContacto = tableViewerColumn_3.getColumn();
		tblclmnNombreDelContacto.setWidth(277);
		tblclmnNombreDelContacto.setText("Nombre del contacto");
		
		Group grpVendedor = new Group(this, SWT.NONE);
		grpVendedor.setText("Vendedor");
		grpVendedor.setBounds(10, 10, 382, 179);
		
		Label lblNombreDelVendedor = new Label(grpVendedor, SWT.NONE);
		lblNombreDelVendedor.setBounds(10, 49, 47, 15);
		lblNombreDelVendedor.setText("Nombre ");
		
		txtNombreVendedor = new Text(grpVendedor, SWT.BORDER);
		txtNombreVendedor.setBounds(10, 70, 88, 21);
		
		Label lbl_IconoUsiario = new Label(grpVendedor, SWT.NONE);
		lbl_IconoUsiario.setImage(SWTResourceManager.getImage("C:\\estructuraDatos\\proyecto2\\resources\\iconoUsuario2.png"));
		lbl_IconoUsiario.setBounds(178, 23, 146, 133);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
