<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Professores - AulaReposição</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron text-center">
            <h1>PROFESSORES</h1>
        </div>
        <div class="row">
            <div class="col">
                <form action="/professores/add" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input id="profnome" type="text" class="validate" name="profnome" value="${(prof.nomeProf)!}">=
                            <label for="profnome">Nome do Professor</label>
                        </div>
                    </div>
                    <button class="btn waves-effect waves-light" type="submit" name="action">ADICIONAR
                        <i class="material-icons right">add_circle</i>
                    </button>
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <table class="table table-striped table-hover">
                    <thead class="thead-dark">
                        <th>ID</th>
                        <th>NOME DO PROFESSOR</th>
                        <th>OPÇÕES</th>
                    </thead>
                    <tbody>
                        <#list profs as prof>
                            <tr>
                                <td>${prof.id}</td>
                                <td>${prof.nomeProf}</td>
                                <td>
                                    <a class="green btn" href="/professores/edit/id=${prof.id}">EDITAR
                                        <i class="material-icons prefix">border_color</i>
                                    </a>
                                    <a class="red btn" href="/professores/remove/id=${prof.id}">EXCLUIR
                                        <i class="material-icons prefix">cancel</i>
                                    </a>
                                </td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>
