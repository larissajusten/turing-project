import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import { CadastrarQuestaoScreen, BuscarQuestao, CadastrarProvaScreen } from './tela/index';
import { Header, Footer } from './component/index'

function App() {
	return (
		<div className="principal">
			<BrowserRouter>
				<Header/>
				<Switch>
					<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen} exact/>
					<Route path="/buscar-questao" component={BuscarQuestao} exact/>
					<Route path="/cadastrar-prova" component={CadastrarProvaScreen} exact/>
				</Switch>
				<Footer/>
				</BrowserRouter>
		</div>
	);
}

export default App;
