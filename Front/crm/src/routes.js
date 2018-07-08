import MainNav from './components/MainNav';
import Companies from './components/companies/Companies';
import Company from './components/companies/Company';
import CompanyCreate from './components/companies/Create';
import DepartmentCreate from './components/departments/Create';
import UserCreate from './components/users/Create';
import PositionCreate from './components/positions/Create';
import User from './components/users/User';
import Department from './components/departments/Department';
import UsersSearch from './components/users/Search';
import DepartmentSearch from './components/departments/Search';
import MessagesList from './components/messages/List';
import Chat from './components/messages/Chat';

export const routes = [
    {path: '/companies', component:MainNav, children:[
            {path: '', name:'companies', component: Companies},
            {path: ':cid', name:'company-single', component: Company},
            {path: ':cid/department/:did/position/create', name:'position-create', component:PositionCreate },
            {path: ':cid/department/create', name:'department-create', component:DepartmentCreate},
            {path: ':cid/department/:did', name:'department-single', component:Department},
            {path: ':cid/department/:did/user/create', name:'user-create', component:UserCreate},
            {path: ':cid/department/:did/user/:uid', name:'user-single', component:User},
            {path: 'users', name:'users-search', component:UsersSearch},
            {path: 'departments', name:'departments-search', component: DepartmentSearch},

            {path: 'create', name:'company-create', component:CompanyCreate},
        ]},
    {path: '/messages', name:'', component: MainNav, children:[
            {path: '', name:'messages', component: MessagesList},
            {path: ':recipientId', name:'chat', component:Chat},
        ]},
];