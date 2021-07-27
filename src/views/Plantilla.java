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

public class Plantilla extends Composite {
	private Table table;
	private Text text;
	private Table table_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Plantilla(Composite parent, int style) {
		super(parent, style);
		
		Group grpMuro = new Group(this, SWT.NONE);
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
		
		Group grpComentariosYMe = new Group(this, SWT.NONE);
		grpComentariosYMe.setText("Comentarios y me gusta");
		grpComentariosYMe.setBounds(398, 195, 302, 329);
		
		Group grpContactos = new Group(this, SWT.NONE);
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
		
		Group grpVendedor = new Group(this, SWT.NONE);
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

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
