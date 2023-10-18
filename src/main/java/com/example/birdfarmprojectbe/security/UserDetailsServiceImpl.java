package com.example.birdfarmprojectbe.security;



import com.example.birdfarmprojectbe.models.Account;
import com.example.birdfarmprojectbe.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Đánh dấu đây là một Spring Service để thực hiện logic xử lý đăng nhập và xác thực người dùng
@RequiredArgsConstructor // Tự động tạo constructor với tham số cho các trường được đánh dấu là final
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final AccountRepository accountRepository; // Sử dụng Spring để tiêm UserRepository vào Service

    @Override
    public UserDetails loadUserByUsername(String accountID) throws UsernameNotFoundException {
        // Phương thức này được gọi khi có yêu cầu xác thực người dùng bằng tên đăng nhập (ở đây là email)

        // Tìm kiếm người dùng trong cơ sở dữ liệu bằng địa chỉ email
        return accountRepository.findAccountByAccountId(accountID)
                .map(UserRegistrationDetails::new) // Nếu tìm thấy, chuyển đổi thành UserRegistrationDetails
                .orElseThrow(() -> new UsernameNotFoundException("User not found")); // Nếu không tìm thấy, ném ngoại lệ UsernameNotFoundException
    }

    public void updatePassword(String accountID, String encodedPassword) {
        // Tìm người dùng trong cơ sở dữ liệu bằng email
        Optional<Account> userOptional = accountRepository.findAccountByAccountId(accountID);

        if (userOptional.isPresent()) {
            // Nếu người dùng tồn tại, lấy thông tin người dùng
            Account users = userOptional.get();

            // Cập nhật mật khẩu đã mã hóa vào thông tin người dùng
            users.setPassword(encodedPassword);

            // Lưu thông tin người dùng cập nhật vào cơ sở dữ liệu
            accountRepository.save(users);
        } else {
            // In ra thông báo lỗi nếu không tìm thấy người dùng
            System.out.println("NOT FOUND USER");
        }
    }

}

