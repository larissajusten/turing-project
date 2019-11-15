import React from 'react';
import { BrowserRouter, Switch, Route, Router } from 'react-router-dom';
import './App.css';
import { CadastrarQuestaoScreen, BuscarQuestao } from './tela/index';
import { Header, Footer } from './component/index'

function App() {
	return (
		<div className="principal">
			<BrowserRouter>
				<Header/>
				<Switch>
					<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen} exact/>
					<Route path="/buscar-questao" component={BuscarQuestao} exact/>
				</Switch>
				<Footer/>
				</BrowserRouter>
		</div>
	);
}

export default App;
