package engineering;

@Controller
public class HttpMethodMisconfigurationExample {

    // 1) No 'method' attribute → all HTTP verbs allowed
    @RequestMapping("/delete_user")
    public String deleteUser(String username) {
        // state-changing operation
        return "deleted";
    }

    // 2) Mixed safe + unsafe methods → GET (safe) and POST (unsafe) allowed together
    @RequestMapping(
        path = "/update_profile",
        method = { RequestMethod.GET, RequestMethod.POST }
    )
    public String updateProfile(String data) {
        // state-changing operation
        return "updated";
    }
}