
package tadashi.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadashi.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import tadashi.demo.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscarUsuario() {
        return this.usuarioService.buscar();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarios(@PathVariable Long id) {
        return this.usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @PutMapping("/id")
    public ResponseEntity<Usuario> atualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {
        Usuario usuarioAtualizar = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioAtualizar);
    }
    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
