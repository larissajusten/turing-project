import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import ReactNotifications from 'react-notifications-component'
import './App.css';
import { CadastrarQuestaoScreen,
				BuscarQuestaoScreen,
				CadastrarProvaScreen,
				VisualizarProvaScreen,
				ResolverProvaScreen } from './tela/index';
import { Header, Footer } from './component/index'

function App() {
	return (
		<div className="principal">
			<ReactNotifications />
			<BrowserRouter>
				<Header/>
				<Switch>
					<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen} exact/>
					<Route path="/buscar-questao" component={BuscarQuestaoScreen}/>
					<Route path="/cadastrar-prova" component={CadastrarProvaScreen}/>
					<Route path="/visualizar-prova" component={VisualizarProvaScreen}/>
					<Route path="/resolver-prova" component={ResolverProvaScreen}/>
				</Switch>
				<Footer/>
				</BrowserRouter>
		</div>
	);
}

export default App;
