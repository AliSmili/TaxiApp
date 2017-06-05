package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.controlTaxi;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class aplicacionTaxi extends JFrame {

	public JFrame frame;
	private JLabel lblSubida;
	private JLabel lblBajada;
	private JLabel lblTaxiApp;
	private JLabel lblTarifa;
	private JLabel lblTarifaCalculada;
	private JTextField txtEfectivoCliente;
	private int hora1, minutos1, segundos1;
	private int hora2, minutos2, segundos2;
	private int tpoViajeMin;
	private float devolucion;
	private JLabel lblDevoCalculada;
	private JLabel lblHora1;
	private JLabel lblHora2;
	private JLabel lblMin1;
	private JLabel lblMin2;
	private JLabel lblSeg1;
	private JLabel lblSeg2;
	private JLabel lblTpoTotal;
	private JList listBajadaBandera;
	private JList listSuplementoNoche;
	private JList listSuplementoAeroPuerto;
	private float suplementos;
	private float tarifa;
	private final float PRECIO_NORMAL = 3.65f;
	private final float PRECIO_ESPECIAL = 4.55f;
	private final float SUPLEMENTO_AEROPUERTO = 5.5f;
	private final float SUPLEMENTO_NOCHE = 2.0f;
	private final float PRECIO_MINUTO1 = 0.18f;
	private final float PRECIO_MINUTO2 = 0.26f;

	
	/**
	 * Create the application.
	 */
	public aplicacionTaxi() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblTaxiApp = new JLabel("TAXI APP");
		lblTaxiApp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTaxiApp.setBounds(275, 11, 121, 30);
		frame.getContentPane().add(lblTaxiApp);

		lblSubida = new JLabel("SUBIDA VIAJERO");
		lblSubida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSubida.setBounds(10, 58, 156, 30);
		frame.getContentPane().add(lblSubida);

		lblBajada = new JLabel("BAJADA VIAJERO");
		lblBajada.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBajada.setBounds(10, 99, 156, 30);
		frame.getContentPane().add(lblBajada);

		JLabel lblTpoTranscurrido = new JLabel("TIEMPO TRANSCURRIDO");
		lblTpoTranscurrido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTpoTranscurrido.setBounds(10, 140, 233, 30);
		frame.getContentPane().add(lblTpoTranscurrido);

		JLabel lblSuplemento = new JLabel("SUPLEMENTOS");
		lblSuplemento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSuplemento.setBounds(10, 190, 156, 30);
		frame.getContentPane().add(lblSuplemento);

		JLabel lblBajadaBandera = new JLabel("BAJADA DE BANDERA");
		lblBajadaBandera.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBajadaBandera.setBounds(32, 231, 168, 30);
		frame.getContentPane().add(lblBajadaBandera);

		JLabel lblSuplementoNoche = new JLabel("SUPLEMENTO NOCHE");
		lblSuplementoNoche.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSuplementoNoche.setBounds(32, 290, 156, 30);
		frame.getContentPane().add(lblSuplementoNoche);

		JLabel lblSuplementoAeroPuerto = new JLabel("SUPLEMENTO AEROPUERTO");
		lblSuplementoAeroPuerto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSuplementoAeroPuerto.setBounds(32, 331, 207, 30);
		frame.getContentPane().add(lblSuplementoAeroPuerto);

		JLabel lblEfectivoCliente = new JLabel("EFECTIVO CLIENTE");
		lblEfectivoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEfectivoCliente.setBounds(401, 231, 146, 30);
		frame.getContentPane().add(lblEfectivoCliente);

		lblTarifa = new JLabel("TARIFA");
		lblTarifa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarifa.setBounds(401, 290, 74, 30);
		frame.getContentPane().add(lblTarifa);

		JLabel lblDevolucion = new JLabel("DEVOLUCION");
		lblDevolucion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDevolucion.setBounds(401, 341, 121, 30);
		frame.getContentPane().add(lblDevolucion);

		JLabel lblHoraSubida = new JLabel("Hora");
		lblHoraSubida.setBounds(186, 69, 37, 14);
		frame.getContentPane().add(lblHoraSubida);

		JLabel lblMinutoSubida = new JLabel("minutos");
		lblMinutoSubida.setBounds(287, 69, 46, 14);
		frame.getContentPane().add(lblMinutoSubida);

		JLabel lblSegundos = new JLabel("segundos");
		lblSegundos.setBounds(429, 69, 59, 14);
		frame.getContentPane().add(lblSegundos);

		JLabel lblHoraBajada = new JLabel("Hora");
		lblHoraBajada.setBounds(186, 110, 37, 14);
		frame.getContentPane().add(lblHoraBajada);

		JLabel lblMinBajada = new JLabel("minutos");
		lblMinBajada.setBounds(287, 110, 46, 14);
		frame.getContentPane().add(lblMinBajada);

		JLabel lblSegundosBajada = new JLabel("segundos");
		lblSegundosBajada.setBounds(429, 105, 59, 24);
		frame.getContentPane().add(lblSegundosBajada);

		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setBounds(411, 151, 46, 14);
		frame.getContentPane().add(lblMinutos);

		JButton btnCalacularPrecio = new JButton("CALCULAR TARIFA");

		/**
		 * CALCULAR TARIFA
		 */
		btnCalacularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				suplementos = 0;
				tarifa = 0;
				devolucion = 0;
				
				
				if(txtEfectivoCliente.getText() == null || Float.parseFloat(txtEfectivoCliente.getText())== 0){
					JOptionPane.showMessageDialog(null,  "ERROR EN EL IMPORTE DEL CLIENTE","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				
				//"FINES/FESTIVOS"

				if (listSuplementoNoche.getSelectedValue().equals("SI")) {
					suplementos += SUPLEMENTO_NOCHE;
				}
				
				//SUPLEMENTO_AEROPUERTO

				if (listSuplementoAeroPuerto.getSelectedValue().equals("SI")) {
					suplementos += SUPLEMENTO_AEROPUERTO;
				}

				// CALCIULAMOS LA TARIFA A BASE DE LOS DATOS SELECCIONADOS Y DEPENDIENDO SI SON DIAS LABORABLES O FINESDE SEMANA/FESTIVOS

				if (listBajadaBandera.getSelectedValue().equals("LABORABLES")) {
					suplementos += PRECIO_NORMAL;
					/*tarifa = suplementos + (PRECIO_MINUTO1 * (Float.parseFloat(lblMin2.getText()))
							- (Float.parseFloat(lblMin1.getText())));*/
					tarifa = suplementos + (PRECIO_MINUTO1 * tpoViajeMin );
				} 
				if(listBajadaBandera.getSelectedValue().equals("FINES/FESTIVOS")) {
					
					suplementos += PRECIO_ESPECIAL;
					/*tarifa = suplementos + (PRECIO_MINUTO2 * (Float.parseFloat(lblMin2.getText()))
							- (Float.parseFloat(lblMin1.getText())));*/
					//tpoViajeMin
					tarifa = suplementos + (PRECIO_MINUTO2 * tpoViajeMin );
				}

				lblTarifaCalculada.setText("" + tarifa);

				if ((Float.parseFloat(txtEfectivoCliente.getText()) <= 3.0f)
						|| (Float.parseFloat(txtEfectivoCliente.getText()) < Float.parseFloat(lblTarifaCalculada.getText()))) {

					JOptionPane.showMessageDialog(null, "EL IMPORTE DEL CLIENTE NO ES VALIDO", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {

					devolucion = Float.parseFloat(txtEfectivoCliente.getText()) - Float.parseFloat(lblTarifaCalculada.getText());
					lblDevoCalculada.setText("" + devolucion);

				}
			}
		});
		btnCalacularPrecio.setBounds(186, 412, 164, 46);
		frame.getContentPane().add(btnCalacularPrecio);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * GUARDAMOS LOS DATOS EN NUESTRA LISTA
				 */
				try {
					controlTaxi.Aniadir(Integer.parseInt(lblHora1.getText()), Integer.parseInt(lblMin1.getText()),
							Integer.parseInt(lblSeg1.getText()), Integer.parseInt(lblHora2.getText()),
							Integer.parseInt(lblMin2.getText()), Integer.parseInt(lblSeg2.getText()), tarifa);
					JOptionPane.showMessageDialog(null, "Se añadio con exito la descripcion de la reparación para este vehículo", "GUARDAR REPARACION", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR AL AÑADIR EL VIAJE",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(10, 412, 164, 46);
		frame.getContentPane().add(btnGuardar);

		lblDevoCalculada = new JLabel("");
		lblDevoCalculada.setBounds(553, 341, 114, 24);
		frame.getContentPane().add(lblDevoCalculada);

		lblTarifaCalculada = new JLabel("");
		lblTarifaCalculada.setBounds(553, 290, 114, 24);
		frame.getContentPane().add(lblTarifaCalculada);

		txtEfectivoCliente = new JTextField();
		txtEfectivoCliente.setBounds(557, 231, 110, 27);
		frame.getContentPane().add(txtEfectivoCliente);
		txtEfectivoCliente.setColumns(10);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		btnSalir.setBounds(532, 412, 164, 46);
		frame.getContentPane().add(btnSalir);

		JButton btnIniciar = new JButton("INICIAR");
		/**
		 * CAPTURAMOS LA HORA DEL SISTEMA Y LA INGRESAMOS CUANDO PULSAMOS
		 * INICIAR
		 */
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendario = new GregorianCalendar();
				hora1 = calendario.get(Calendar.HOUR_OF_DAY);
				minutos1 = calendario.get(Calendar.MINUTE);
				segundos1 = calendario.get(Calendar.SECOND);

				lblHora1.setText("" + hora1);
				lblMin1.setText("" + minutos1);
				lblSeg1.setText("" + segundos1);
			}
		});
		btnIniciar.setBounds(597, 26, 94, 46);
		frame.getContentPane().add(btnIniciar);

		/**
		 * CAPTURAMOS LA HORA DEL SISTEMA Y LA INGRESAMOS CUANDO PULSAMOS PARAR
		 */

		JButton btnParar = new JButton("PARAR");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendario = new GregorianCalendar();
				hora2 = calendario.get(Calendar.HOUR_OF_DAY);
				minutos2 = calendario.get(Calendar.MINUTE);
				segundos2 = calendario.get(Calendar.SECOND);
				
				tpoViajeMin = minutos2 - minutos1;

				lblHora2.setText("" + hora2);
				lblMin2.setText("" + minutos2);
				lblSeg2.setText("" + segundos2);
				lblTpoTotal.setText(""+tpoViajeMin);

			}
		});
		btnParar.setBounds(597, 120, 94, 46);
		frame.getContentPane().add(btnParar);

		/**
		 * LISTAS DE SUPLEMENTOS
		 */

		listBajadaBandera = new JList();
		listBajadaBandera.setModel(new AbstractListModel() {
			String[] values = new String[] { "LABORABLES", "FINES/FESTIVOS" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listBajadaBandera.setSelectedIndex(0);

		listBajadaBandera.setBounds(242, 223, 88, 46);
		frame.getContentPane().add(listBajadaBandera);

		listSuplementoNoche = new JList();
		listSuplementoNoche.setModel(new AbstractListModel() {
			String[] values = new String[] { "SI", "NO" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listSuplementoNoche.setSelectedIndex(0);

		listSuplementoNoche.setBounds(242, 282, 53, 38);
		frame.getContentPane().add(listSuplementoNoche);

		listSuplementoAeroPuerto = new JList();
		listSuplementoAeroPuerto.setModel(new AbstractListModel() {
			String[] values = new String[] { "SI", "NO" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listSuplementoAeroPuerto.setSelectedIndex(0);

		listSuplementoAeroPuerto.setBounds(242, 331, 53, 38);
		frame.getContentPane().add(listSuplementoAeroPuerto);

		lblHora1 = new JLabel("");
		lblHora1.setBounds(219, 63, 59, 25);
		frame.getContentPane().add(lblHora1);

		lblMin1 = new JLabel("");
		lblMin1.setBounds(343, 63, 59, 25);
		frame.getContentPane().add(lblMin1);

		lblSeg1 = new JLabel("");
		lblSeg1.setBounds(498, 64, 59, 24);
		frame.getContentPane().add(lblSeg1);

		lblHora2 = new JLabel("");
		lblHora2.setBounds(219, 105, 59, 24);
		frame.getContentPane().add(lblHora2);

		lblMin2 = new JLabel("");
		lblMin2.setBounds(343, 105, 59, 24);
		frame.getContentPane().add(lblMin2);

		lblSeg2 = new JLabel("");
		lblSeg2.setBounds(498, 105, 59, 24);
		frame.getContentPane().add(lblSeg2);

		lblTpoTotal = new JLabel("");
		lblTpoTotal.setBounds(298, 146, 74, 24);
		frame.getContentPane().add(lblTpoTotal);
		
		JLabel lblEuro = new JLabel("€");
		lblEuro.setBounds(671, 241, 20, 14);
		frame.getContentPane().add(lblEuro);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(671, 300, 20, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setBounds(677, 347, 20, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnReset = new JButton("RESET");
		/**
		 * RESET
		 */
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					lblHora1.setText(null);
					lblHora2.setText(null);
					lblMin1.setText(null);
					lblMin2.setText(null);
					lblSeg1.setText(null);
					lblSeg2.setText(null);
					txtEfectivoCliente.setText(null);
					lblTarifaCalculada.setText(null);
					lblDevoCalculada.setText(null);
					
				
			}
		});
		btnReset.setBounds(368, 412, 164, 46);
		frame.getContentPane().add(btnReset);
	}

}
