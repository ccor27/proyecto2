package views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import ModelFactoryController.RedSocialController;
import modelo.Enlace;
import modelo.Producto;
import modelo.Vendedor;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Plantilla extends Composite {
	private Table tblProductos;
	private Text txtNombreVendedor;
	private Table tblContactos;
	private Text txtAreaComentMeg;
	private Text txtComentario;

	private RedSocial red;
	private Vendedor vend = new Vendedor();
	private Vendedor vendedorSeleccionadoTabla = new Vendedor();
	private String comentarios="";
	private ArrayList<Producto> listaProd = new ArrayList<>();
	private ArrayList<Enlace> listaEnlaces = new ArrayList<>();
	private RedSocialController controller = new RedSocialController();;
	
	private TableColumn tblclmnNombre;
	private TableColumn tblclmnFechaYHora;
	private TableColumn tblclmnPublicadoPor;
	private TableViewer tableViewer;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Plantilla(Composite parent, int style, String nombreVend) {
		super(parent, style);

		//System.out.println("nombre del vendedor: "+nombreVend);
		vend =controller.obtenerVendedor(nombreVend);
		
		//System.out.println("vendedor(linea 51 plantilla): "+vend);
		//llenarTablaProd();
		
		Group grpMuro = new Group(this, SWT.NONE);
		grpMuro.setText("Muro");
		grpMuro.setBounds(10, 195, 382, 265);
		
		tableViewer = new TableViewer(grpMuro, SWT.BORDER | SWT.FULL_SELECTION);
		tblProductos = tableViewer.getTable();
		tblProductos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
			String nombre =  tblProductos.getItem(tblProductos.getSelectionIndex()).getText();
			
			if(listaEnlaces.size()!=0){
				for (Enlace enlace : listaEnlaces) {
					ArrayList<Producto> list = enlace.getNodo().getVendedor().getListaProductosArray();
					for (Producto producto : list) {
						if(producto.getNombre().equalsIgnoreCase(nombre))
							vendedorSeleccionadoTabla=enlace.getNodo().getVendedor();
					}
				}
			}else{
				vendedorSeleccionadoTabla = vend;
			}
//			System.out.println(nombre);
//			vendedorSeleccionadoTabla = controller.obtenerVendedor(nombre);

			}
		});
		tblProductos.setLinesVisible(true);
		tblProductos.setHeaderVisible(true);
		tblProductos.setBounds(10, 22, 362, 229);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNombre = tableViewerColumn.getColumn();
		tblclmnNombre.setWidth(128);
		tblclmnNombre.setText("Producto");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnFechaYHora = tableViewerColumn_1.getColumn();
		tblclmnFechaYHora.setWidth(127);
		tblclmnFechaYHora.setText("Fecha y hora");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnPublicadoPor = tableViewerColumn_2.getColumn();
		tblclmnPublicadoPor.setWidth(103);
		tblclmnPublicadoPor.setText("Publicado por");
		
		Group grpComentariosYMe = new Group(this, SWT.NONE);
		grpComentariosYMe.setText("Comentarios y me gusta");
		grpComentariosYMe.setBounds(398, 195, 302, 265);
		
		txtAreaComentMeg = new Text(grpComentariosYMe, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		txtAreaComentMeg.setEnabled(false);
		txtAreaComentMeg.setEditable(false);
		txtAreaComentMeg.setBounds(10, 32, 282, 157);
		
		txtComentario = new Text(grpComentariosYMe, SWT.BORDER);
		txtComentario.setBounds(10, 213, 101, 21);
		
		Button btnComentar = new Button(grpComentariosYMe, SWT.NONE);
		btnComentar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if(vendedorSeleccionadoTabla!=null && !txtComentario.getText().equalsIgnoreCase("")){
					comentarios+=" "+vend.getNombre()+" comento el producto de: "+vendedorSeleccionadoTabla.getNombre()+"\n"+txtComentario.getText()+"\n";
					txtAreaComentMeg.setText(comentarios);
					
					ArrayList<String> listEnlace = new ArrayList<>();
					for (Enlace enlace : listaEnlaces) {
						listEnlace.add(enlace.getNodo().getVendedor().getNombre());
					}
					red.comentarEnEnlazados(listEnlace, " "+vend.getNombre()+" comento el producto de: "+vendedorSeleccionadoTabla.getNombre()+"\n"+txtComentario.getText()+"\n");
				}else{
					System.out.println("no comenta");
				}
				
				//comentar
			}
		});
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
		txtNombreVendedor.setEnabled(false);
		txtNombreVendedor.setEditable(false);
		txtNombreVendedor.setBounds(10, 70, 88, 21);
		txtNombreVendedor.setText(nombreVend);
		
		Label lbl_IconoUsiario = new Label(grpVendedor, SWT.NONE);
		lbl_IconoUsiario.setImage(SWTResourceManager.getImage("C:\\estructuraDatos\\proyecto2\\resources\\iconoUsuario2.png"));
		lbl_IconoUsiario.setBounds(178, 23, 146, 133);

	}
	
	public void llenarTablaProd(){
		
		listaEnlaces = controller.getListaEnlaces(vend.getNombre());
		listaProd.clear();
		tblProductos.clearAll();
		if(listaEnlaces.size()==0){//si no hay enlaces, muestra solo los productos del vendedor
			
			listaProd = vend.getListaProductosArray();
			if(listaProd!=null){
				System.out.println("entro a llenar tablaprod "+listaProd);
				for (Producto producto : listaProd) {
					System.out.println("entro al for");
					TableItem item = new TableItem(tblProductos,SWT.NONE);
					item.setText(new String[] {producto.getNombre(),producto.getFechaHora(),vend.getNombre()});
				}
			}else{
				System.out.println("lista vacia");	
			}
		}else{//si hay nodos enlazados, muestra los productos de todos
			System.out.println("lista con enlaces");
			for (Enlace enlace : listaEnlaces) {
				
				listaProd = enlace.getNodo().getVendedor().getListaProductosArray();
				if(listaProd!=null){
					//System.out.println("entro a llenar tablaprod");
					for (Producto producto : listaProd) {
						//System.out.println("entro al for");
						TableItem item = new TableItem(tblProductos,SWT.NONE);
						item.setText(new String[] {producto.getNombre(),producto.getFechaHora(),vend.getNombre()});
					}
				}
			}
		}
		

		
//		listaProd = vend.getListaProductosArray();
//		if(listaProd!=null){
//			//System.out.println("entro a llenar tablaprod");
//			for (Producto producto : listaProd) {
//				//System.out.println("entro al for");
//				TableItem item = new TableItem(tblProductos,SWT.NONE);
//				item.setText(new String[] {producto.getNombre(),producto.getFechaHora(),vend.getNombre()});
//			}
//		}
	}
	public void llenarTablaCont(){
	
		listaEnlaces = controller.getListaEnlaces(vend.getNombre());
		tblContactos.removeAll();

		if(listaEnlaces!=null){
			for (Enlace enlace : listaEnlaces) {
				TableItem item = new TableItem(tblContactos,SWT.NONE);
				if(enlace.getNodo()!=null){
					item.setText(new String[] {enlace.getNodo().getVendedor().getNombre()});	
				}
			}
			}else{
			System.out.println("lista enlaces vacia");
		}
	}
	
	public void comentarProduct(String mensaje){
		txtAreaComentMeg.setText(mensaje);
	}

	public void setRed(RedSocial red){
		this.red =red;
	}
	public String getNombreVend(){
		return vend.getNombre();
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
