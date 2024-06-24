package com.IgorAntonio22.Principal;

import com.IgorAntonio22.service.ArtistaService;
import com.IgorAntonio22.service.MusicaService;

import java.util.Scanner;

public class Principal {

    ArtistaService artistaService;

    MusicaService musicaService;

    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaService artistaService, MusicaService musicaService) {
        this.artistaService = artistaService;
        this.musicaService = musicaService;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {

            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista (Configure sua API_KEY da OpenAI em ConsultaChatGPT)
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch(opcao) {
                case 1:
                cadastrarArtista();
                    break;
                case 2:
                cadastrarMusicas();
                    break;
                case 3:
                listarMusicas();
                    break;
                case 4:
                buscarMusicaPorArtistas();
                    break;
                case 5:
                pesquisarDadosSobreUmArtista();
                    break;
                case 0:
                    System.out.println("Saindo da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }


    public void cadastrarArtista() {
        System.out.println("Digite o nome do Artista: ");
        var nomeDoArtista = leitura.nextLine().toLowerCase();


        System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
        var tipoDoArtista = leitura.nextLine().toLowerCase();

        artistaService.cadastrarArtista(nomeDoArtista, tipoDoArtista);
    }

    public void cadastrarMusicas() {
        System.out.println("Digite o nome da Música: ");
        var nomeDaMusica = leitura.nextLine().toLowerCase();

        System.out.println("Digite o nome do Artista: ");
        var nomeDoArtista = leitura.nextLine().toLowerCase();

        musicaService.cadastrarMusicas(nomeDaMusica, nomeDoArtista);

    }

    private void listarMusicas() {
        musicaService.listaMusicas();
    }


    private void buscarMusicaPorArtistas() {
        System.out.println("Digite o nome do artista: ");
        var nomeDoArtista = leitura.nextLine().toLowerCase();

        musicaService.buscarMusicasPorArtistas(nomeDoArtista);
    }

    private void pesquisarDadosSobreUmArtista() {
        System.out.println("Digite o nome do artista: ");
        var nomeDoArtista = leitura.nextLine().toLowerCase();

        artistaService.pesquisarDadosSobreUmArtista(nomeDoArtista);
    }
}
