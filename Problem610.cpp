#include <iostream>
#include <string>

using namespace std;

int main(){
	int veces;
	cin >> veces;
	for(int i=0;i<veces;i++){
		int n, s, p, k;
		bool starklive=true, peterlive=true;
		cin >> n; cin >> s; cin >> p; cin >> k;
		if(n<2 || n>1000){continue;}
		if(s<1 || s>n || s==p){continue;}
		if(p<1 || p>n){ continue;}
		if(k<0 || k>20){ continue;}
		string rueda="";
		for(int j=0;j<n;j++){
			rueda+= (j+1==s)?"s":(j+1==p)?"p":"x";
		}
		int counter=0;
		do{
                counter+=k;
                counter = (counter>= rueda.length())? (counter-((counter/rueda.length())*rueda.length())) : counter;
                starklive=(rueda[counter]=='s')? false : starklive;
                peterlive=(rueda[counter]=='p')? false : peterlive;
                rueda.erase(counter,1);
        }while(rueda.length()>n/2);
        
        if(!peterlive && starklive ){
            cout << "No quiero irme, Sr. Stark!\n";
        }else if(peterlive && !starklive){
            cout << "No quiero irme, Peter!\n";
        }else{
            cout << "No hay abrazo\n";
        }
	}
	return 0;
}
