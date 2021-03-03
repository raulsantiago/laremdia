package app.br.laremdia.model.api.rest;

import app.br.laremdia.model.entity.LoginProfissional;
import app.br.laremdia.model.repository.LoginProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loginprofissional")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginProfissionalController {

    private final LoginProfissionalRepository loginProfissionalRepository;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public LoginProfissional consultar(@PathVariable Integer id){
        return loginProfissionalRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado."));
    }

    @GetMapping()
    public List<LoginProfissional> listar(){
        return loginProfissionalRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginProfissional incluir(@RequestBody @Valid LoginProfissional loginProfissional){
        return loginProfissionalRepository.save(loginProfissional);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterar(@PathVariable Integer id, @RequestBody @Valid LoginProfissional loginProfissional){
        loginProfissionalRepository.findById(id).map( profissional -> {
            profissional.setNome(loginProfissional.getNome());
            profissional.setEmail(loginProfissional.getEmail());
            profissional.setCpf(loginProfissional.getCpf());
            profissional.setCelular(loginProfissional.getCelular());
            profissional.setSenha(loginProfissional.getSenha());
            profissional.setAtivo(loginProfissional.getAtivo());
            return loginProfissionalRepository.save(profissional);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado."));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        loginProfissionalRepository.findById(id).map( profissional -> {
            loginProfissionalRepository.delete(profissional);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado."));
    }

    @PutMapping("{id}/foto")
    public byte[] addFoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo){
        Optional<LoginProfissional> loginProfissional = loginProfissionalRepository.findById(id);
        return loginProfissional.map( lp -> {
            try{
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                lp.setFoto(bytes);
                loginProfissionalRepository.save(lp);
                is.close();
                return bytes;
            }catch (IOException e){
                return null;
            }
        }).orElse(null);
    }

}
