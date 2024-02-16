package AirlineManager;

import javax.swing.JOptionPane;

public class Caution {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Đăng kí thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
		
		
		//JOptionPane.showMessageDialog(null, "Thông tin đăng kí không đủ", "Thông báo", JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Đăng kí thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
		////JOptionPane.showMessageDialog(null, "Mật khẩu sai", "Thông báo", JOptionPane.ERROR_MESSAGE);
		 //JOptionPane.showConfirmDialog(null, "Đặt chuyến thành công! Bạn muốn tiếp tục hay không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
		 JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn hủy chuyến hay không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
		 JOptionPane.showMessageDialog(null, "Hủy chuyến thành công!", "Thông báo", JOptionPane.CLOSED_OPTION);
		 JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!", "Thông báo", JOptionPane.CLOSED_OPTION);
		}
	}

