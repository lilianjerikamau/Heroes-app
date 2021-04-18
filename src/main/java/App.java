import java.util.ArrayList;
import java.util.HashMap;

import models.Heroes;
import models.Squad;
import spark.ModelAndView;


import java.util.Map;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
public class App {
    public static void main(String[] args){

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        }else {
            port = 4567;
        }
        port(port);

        staticFileLocation("/public");
        Heroes.createNewHero();
        Heroes.createNewHero1();
        Squad.createNewSquad();
//        Squad.setUpNewSquad1();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Heroes> hero = Heroes.getInstances();
            model.put("hero",hero);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Heroes foundHero = Heroes.findById(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Heroes> heroes = Heroes.getInstances();
            model.put("heroes",heroes);
            Squad newSquad = Squad.findById(1);
            model.put("allSquadHeroes", newSquad.getSquadHeroes());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());
//
        post("/squad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int size = Integer.parseInt(req.queryParams("size"));
            String mission = req.queryParams("mission");
            Squad newSquad = new Squad(name,mission,size);
            req.session().attribute("item",name);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
//
        post("/new/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            Heroes newHero = new Heroes(name,age,power,weakness);
            req.session().attribute("item",name);
            model.put("item",req.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
//
        get("/new/member/:squadId",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            req.session().attribute("selectedSquad",req.params("squadId"));
            model.put("selectedSquad", req.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());
//
        get("/squad/new/:id",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(req.params(":id"));
            Heroes newMember = Heroes.findById(id);
            Squad newSquad = Squad.findById(1);
            newSquad.setSquadHeroes(newMember);
            model.put("item", newMember.getName());
            model.put("newHero",newSquad.getName());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}