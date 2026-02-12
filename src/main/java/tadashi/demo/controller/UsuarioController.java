
package tadashi.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadashi.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import tadashi.demo.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/{usuarios}")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscarUsuarios() {
        return this.usuarioService.buscar();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return this.usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {
        Usuario usuarioEditado = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioEditado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();

    }

}
