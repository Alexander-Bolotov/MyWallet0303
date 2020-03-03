package MyWallet.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(Model model) {
        return "/login";
    }

    @RequestMapping(value = "/wallet")
    public String getWalletPage(Model model) {
        return "/wallet";
    }
}
