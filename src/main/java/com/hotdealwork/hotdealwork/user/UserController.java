package com.hotdealwork.hotdealwork.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/delete")
    public String deleteForm() {
        return "delete_form";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        boolean isDeleted = userService.deleteUser(username, password);

        if (isDeleted) {
            model.addAttribute("message", "회원 탈퇴가 성공적으로 완료되었습니다.");
            return "redirect:/"; // 회원탈퇴가 성공하면 홈으로 리다이렉트
        } else {
            model.addAttribute("message", "회원 탈퇴를 실패했습니다.");
            return "delete_form";
        }
    }
}