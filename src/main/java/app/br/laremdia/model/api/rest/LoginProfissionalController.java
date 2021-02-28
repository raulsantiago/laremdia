package app.br.laremdia.model.api.rest;

import app.br.laremdia.model.entity.LoginProfissional;
import app.br.laremdia.model.repository.LoginProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/loginprofissional")
@RequiredArgsConstructor
public class LoginProfissionalController {

    private final LoginProfissionalRepository loginProfissionalRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<LoginProfissional> consulta(@PathVariable Integer id){
        return loginProfissionalRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginProfissional incluir(@RequestBody LoginProfissional loginProfissional){
        return loginProfissionalRepository.save(loginProfissional);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        loginProfissionalRepository.deleteById(id);
    }

}
