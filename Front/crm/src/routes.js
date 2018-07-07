import MainNav from './components/MainNav';
import Companies from './components/companies/Companies';
import Company from './components/companies/Company';
import Users from './components/users/Users';
import CompanyCreate from './components/companies/Create';
import DepartmentCreate from './components/departments/Create';
import UserCreate from './components/users/Create';
import PositionCreate from './components/positions/Create';
import Department from './components/departments/Department';

export const routes = [
    {path: '/companies', component:MainNav, children:[
            {path: '', name:'companies', component: Companies},
            {path: ':cid', name:'company-single', component: Company},
            {path: ':cid/position/create', name:'position-create', component:PositionCreate },
            {path: ':cid/department/create', name:'department-create', component:DepartmentCreate},
            {path: ':cid/department/:did', name:'department-single', component:Department},
            {path: ':cid/department/:did/user/create', name:'user-create', component:UserCreate},
            {path: 'users', name:'users', component:Users},
            {path: 'create', name:'company-create', component:CompanyCreate},
        ]}
];