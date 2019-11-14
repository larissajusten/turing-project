import React from 'react';
import { BrowserRouter as Switch, Route } from 'react-router-dom';
import './App.css';
import { CadastrarQuestaoScreen, BuscarQuestao } from './tela/index';
import { Header } from './component/index'

function App() {
	return (
		<div className="principal">
			<Header/>
			<Switch>
				<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen} exact/>
				<Route path="/buscar-questao" component={BuscarQuestao} exact/>
			</Switch>
		</div>
	);
}

export default App;
