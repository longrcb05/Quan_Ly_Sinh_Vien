package view;

import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import javax.swing.Action;
public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan;
	private DefaultTableModel mode;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	private JTable model_table;
	private ThiSinh ts;
	public JComboBox comboBox_queQuan_timKiem;
	private String maThiSinhTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public QLSVView() {
		setTitle("Hệ thống quản lý học sinh");
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 446);
		
		Action action = new QLSVController(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 733, 22);
		contentPane.add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuFile.add(menuSave);
		
		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAbout.add(menuAboutMe);
		
		JLabel lblNewLabel = new JLabel("Quê quán: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 64, 82, 22);
		contentPane.add(lblNewLabel);
		
		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(81, 65, 134, 22);
		contentPane.add(comboBox_queQuan_timKiem);
		
		JLabel lblM = new JLabel("Mã sinh viên:");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblM.setBounds(225, 64, 94, 22);
		contentPane.add(lblM);
		
		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setBounds(317, 66, 128, 21);
		contentPane.add(textField_MaThiSinh_TimKiem);
		textField_MaThiSinh_TimKiem.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTim.setBounds(461, 64, 89, 23);
		contentPane.add(btnTim);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 97, 675, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách học sinh:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 249, 144, 22);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 270, 655, 126);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã học sinh", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày sinh", "Gi\u1EDBi t\u00EDnh", "Toán", "Vật Lý", "Hóa Học"
			}
		));
		
		table.setRowHeight(25);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin học sinh:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 97, 161, 22);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 246, 685, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_3 = new JLabel("Mã học sinh: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 129, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Họ và tên: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(20, 157, 82, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quê quán:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(20, 182, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày sinh:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(20, 207, 60, 21);
		contentPane.add(lblNewLabel_6);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(105, 126, 144, 22);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setBounds(105, 154, 144, 23);
		contentPane.add(textField_HoVaTen);
		textField_HoVaTen.setColumns(10);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(105, 182, 144, 22);
		contentPane.add(comboBox_queQuan);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setBounds(105, 208, 144, 20);
		contentPane.add(textField_NgaySinh);
		textField_NgaySinh.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Giới tính:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(271, 129, 60, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Toán");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(270, 157, 49, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Lý");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(273, 182, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Hóa");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(273, 210, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton_nam.setBounds(334, 125, 49, 23);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton_nu.setBounds(385, 125, 60, 23);
		contentPane.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setBounds(317, 155, 128, 20);
		contentPane.add(textField_Mon1);
		textField_Mon1.setColumns(10);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(317, 180, 128, 20);
		contentPane.add(textField_Mon2);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(317, 208, 128, 20);
		contentPane.add(textField_Mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThem.addActionListener(action);
		btnThem.setBounds(576, 173, 89, 23);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoa.addActionListener(action);
		btnXoa.setBounds(576, 126, 89, 23);
		contentPane.add(btnXoa);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.addActionListener(action);
		btnUpdate.setBounds(461, 173, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.addActionListener(action);
		btnSave.setBounds(461, 126, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Hủy bỏ");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.addActionListener(action);
		btnDelete.setBounds(518, 212, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHuyTim.setBounds(576, 64, 89, 23);
		contentPane.add(btnHuyTim);
		
		JLabel lblNewLabel_11 = new JLabel("TÌM KIẾM HỌC SINH");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(259, 33, 161, 22);
		contentPane.add(lblNewLabel_11);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		// TODO Auto-generated method stub
		textField_ID.setText(""); 
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	@SuppressWarnings("deprecation")
	public void themThiSinhVaoTable(ThiSinh ts) {
		// TODO Auto-generated method stub
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				model_table.addRow(new Object[] {ts.getMaThiSinh()+"", 
						ts.getTenThiSinh(), 
						ts.getQueQuan().getTenTinh(), 
						ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/" + (ts.getNgaySinh().getYear() + 1900),							(ts.isGioiTinh()?"Nam":"Nữ"),
						ts.getDiemMon1() +"",
						ts.getDiemMon2() +"", 
						ts.getDiemMon3() +""});
	}

	@SuppressWarnings("deprecation")
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
	   // TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		@SuppressWarnings("deprecation")
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	
	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.textField_ID.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		@SuppressWarnings("deprecation")
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1() + "");
		this.textField_Mon2.setText(ts.getDiemMon2() + "");
		this.textField_Mon3.setText(ts.getDiemMon3() + "");
	}
	

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}
	
	

	public void thucHienThemThiSinh() {
		// TODO Auto-generated method stub
		// lấy dữ liệu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		Tinh tinh  = Tinh.getTinhByID(queQuan);
		@SuppressWarnings("deprecation")
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		}else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {
		// TODO Auto-generated method stub
		 // gọi hàm hủy tìm kiếm
		this.thucHienTaiLaiDuLieu();
		//thực hiện tìm kiếm
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer>idCuaThiSinhCanXoa = new TreeSet<>();
		if (queQuan >= 0) {
		Tinh tinhDaChon  = Tinh.getTinhByID(queQuan);
		for (int i = 0; i < soLuongDong; i++) {
			String tenTinh = model_table.getValueAt(i, 2) + "";
			String id = model_table.getValueAt(i, 0) + "";
			if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
				idCuaThiSinhCanXoa.add(Integer.valueOf(id));
			    }
		   }
	  }	
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				  }
			 }
		}
		
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " +idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " +i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				  }
			 }
		}
   }
	
	
	public void thucHienTaiLaiDuLieu() {
		// TODO Auto-generated method stub
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else 
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(this, "Phần mềm quản lý thông tin học sinh");
	}

	public void thoatKhoiChuongTrinh() {
		// TODO Auto-generated method stub
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	 	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		// TODO Auto-generated method stub
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void openFile(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}

	public void thucHienOpenFile() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
}
