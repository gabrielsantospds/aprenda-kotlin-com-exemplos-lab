enum class Nivel { 
    BASICO, 
    INTERMEDIARIO, 
    AVANCADO 
}

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    val listaInscritos: List<Usuario> = inscritos
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirLista() {
        println(listaInscritos)
    }
    
}

fun main() {
    val formacao1 = Formacao("Desenvolvimento Web", Nivel.INTERMEDIARIO, mutableListOf<ConteudoEducacional>(
        ConteudoEducacional("HTML", 40),
        ConteudoEducacional("CSS", 30),
        ConteudoEducacional("JS", 20)
    ))
    
    val formacao2 = Formacao("Desenvolvimento de APIs", Nivel.AVANCADO, mutableListOf<ConteudoEducacional>(
        ConteudoEducacional("Kotlin", 40),
        ConteudoEducacional("POO", 30),
        ConteudoEducacional("SpringBoot", 20)
    ))

    val usuario1 = Usuario("Pedro", "pedro@gmail.com")
    val usuario2 = Usuario("Jeferson", "jeferson@gmail.com")
    val usuario3 = Usuario("Bruno", "bruno@gmail.com")

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario3)
    
    formacao2.matricular(usuario2)

    println(formacao1)
    formacao1.imprimirLista()
    println()
    println(formacao2)
    formacao2.imprimirLista()
}