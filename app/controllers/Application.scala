package controllers

import play.api.mvc.{Action, Controller}
import utils.MavenCentral

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {
    
  def index = Action {
    Async {
      MavenCentral.allWebJars.map { allWebJars =>
        Ok(views.html.index(allWebJars))
      }
    }
  }
  
  def listFiles(artifactId: String, version: String) = Action {
    Ok(MavenCentral.listFiles(artifactId, version))
  }

  def documentation = Action {
    Ok(views.html.documentation())
  }

  def contributing = Action {
    Ok(views.html.contributing())
  }
  
}