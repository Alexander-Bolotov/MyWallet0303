package MyWallet.domain.controller;

import MyWallet.domain.dao.TransactionDao;
import MyWallet.domain.dao.UserDao;
import MyWallet.domain.model.Role;
import MyWallet.domain.model.Transaction;
import MyWallet.domain.model.TypeOfTransaction;
import MyWallet.domain.model.User;
import MyWallet.domain.repository.RoleRepository;
import MyWallet.domain.repository.TransactionRepository;
import MyWallet.domain.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping
@RestController
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    private UserDao userDao;

    static final String USER_FORM = "/user-form";
    static final String USER_DATA = "/userdata";





    @RequestMapping(value = "/update")
    public String update(@RequestParam("userId") long id, Model model) {
        if (id == -1) {
            User user = new User();
            model.addAttribute("user", user);
            return USER_FORM;
        }
        List<Role> roles = roleRepository.findAll();
        User user = userRepository.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return USER_FORM;
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser( @RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("roles") Set<Role> role) {
        User updateUser = userRepository.getOne(id);
        updateUser.setName(name);
        updateUser.setPassword(password);
        updateUser.setRoles(role);
        userRepository.save(updateUser);
        return "redirect:/mainPage";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("userId") long id, Model model) {
        userRepository.deleteById(id);
        return "redirect:/mainPage";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(@RequestParam("userId") long id, Model model) {
        Set<Role> userRoles = new HashSet<>(roleRepository.findAll());
        List<User> userList = userRepository.findAll();
        int i = userList.size();
        Long idLast = userList.get(i - 1).getId();
        User user = new User();
        user.setId(idLast + 1);
        user.setName("");
        user.setPassword("");
        user.setRoles(userRoles);

        model.addAttribute("user", user);
        model.addAttribute("roles", userRoles);
        return USER_FORM;
    }

    @RequestMapping(value = "/userdata")
    public String userdata(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findAllByName(auth.getName());
        model.addAttribute("user", user);
        return USER_DATA;
    }

    @JsonView(Transaction.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getTransactionList() {
        return new ResponseEntity<List<Transaction>>(transactionDao.getAllTransactions(), HttpStatus.OK);
    }

    @JsonView(User.class)
    @RequestMapping(value = "/listuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<List<User>>(userDao.getListUsers(), HttpStatus.OK);
    }
}
