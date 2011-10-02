package com.ocpsoft.rewrite.showcase.composite;

import javax.servlet.ServletContext;

import com.ocpsoft.rewrite.config.Configuration;
import com.ocpsoft.rewrite.config.ConfigurationBuilder;
import com.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import com.ocpsoft.rewrite.servlet.config.rule.Join;

public class CompositeConfigProvider extends HttpConfigurationProvider
{
   @Override
   public Configuration getConfiguration(final ServletContext context)
   {
      return ConfigurationBuilder.begin()

               .defineRule().perform(EncodeQuery.params().to("c"))

               .addRule(Join.path("/").to("/index.xhtml"))

      ;
   }

   @Override
   public int priority()
   {
      return 0;
   }
}