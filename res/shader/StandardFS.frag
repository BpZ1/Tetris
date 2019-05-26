#version 430 core

in vec2 textureCoords;
in vec3 fragmentPosition;

out vec4 out_Color;

uniform sampler2D textureSampler;
uniform vec4 colorVector;
uniform float groundHeight;

struct Light
{ 
	vec4 position;
	vec4 color;
	vec4 attenuation;
	vec4 data; //(brightness, radius, 0, 0)
};

layout(std430, binding = 3) buffer LightData
{
    Light lights[];
};

void main(void)
{
	vec4 fragColor = texture(textureSampler, textureCoords);
	vec4 addedColor = fragColor + colorVector;
	vec4 colorWithLight = addedColor;

	//Light calculations
	for(int i = 0; i < lights.length(); i++){
		if(fragColor.a < 1 || fragmentPosition.z < lights[i].position.z){
			if(lights[i].data.x > 0.01){				
				float distance = distance(fragmentPosition.xy, lights[i].position.xy);
				distance = distance / lights[i].data.y;
				//Light attenuation
				float attenuationFactor = 1 / (lights[i].attenuation.x + (lights[i].attenuation.y * distance) + (lights[i].attenuation.z * distance * distance));
				float brightness = lights[i].data.x;
				vec3 lightColor = lights[i].color.rgb * lights[i].data.x * attenuationFactor;
				colorWithLight = colorWithLight + vec4(lightColor, 0.0);
			}
		}
	}    	
	out_Color = vec4(min(colorWithLight.rgb,(fragColor.rgb + 0.4)), addedColor.a);;
}

