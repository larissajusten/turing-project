import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import { CadastrarQuestaoScreen, BuscarQuestaoScreen, CadastrarProvaScreen, VisualizarProvaScreen } from './tela/index';
import { Header, Footer } from './component/index'
import {  } from './tela/VisualizarProva/visualizarProva.tela';

function App() {
	return (
		<div className="principal">
			<BrowserRouter>
				<Header/>
				<Switch>
					<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen} exact/>
					<Route path="/buscar-questao" component={BuscarQuestaoScreen} exact/>
					<Route path="/cadastrar-prova" component={CadastrarProvaScreen} exact/>
					<Route path="/visualizar-prova" component={VisualizarProvaScreen} exact/>
				</Switch>
				<Footer/>
				</BrowserRouter>
		</div>
	);
}

export default App;
