import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import ReactNotifications from 'react-notifications-component'
import './App.css';
import { LoginScreen,
				CadastrarQuestaoScreen,
				BuscarQuestaoScreen,
				CadastrarProvaScreen,
				VisualizarProvaScreen,
				ResolverProvaScreen,
				BuscarProvaParaCorrigirScreen,
				CorrigirProvaScreen,
				BuscarProvaJaCorrigidaScreen,
				ProvaPDFScreen,
				TelaInicialScreen } from './tela/index';
import { Header, Footer } from './component/index'

function App() {
	return (
		<>
			<BrowserRouter>
				<Switch>
					<Route path="/resolver-prova/:token" component={ResolverProvaScreen}/>
					<Route path="/login" component={LoginScreen} exact/>
					<div className="principal">
					<ReactNotifications/>
					<Header/>
					<Route path="/" component={TelaInicialScreen} exact/>
					<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen}/>
					<Route path="/buscar-questao" component={BuscarQuestaoScreen}/>
					<Route path="/cadastrar-prova" component={CadastrarProvaScreen}/>
					<Route path="/visualizar-prova" component={VisualizarProvaScreen}/>
					<Route path="/buscar-provas" component={BuscarProvaParaCorrigirScreen}/>
					<Route path="/corrigir-prova" component={CorrigirProvaScreen}/>
					<Route path="/provas-corrigidas" component={BuscarProvaJaCorrigidaScreen}/>
					<Route path="/prova-PDF" component={ProvaPDFScreen}/>
					<Footer/>
					</div>
				</Switch>
			</BrowserRouter>
		</>
	);
}

export default App;
