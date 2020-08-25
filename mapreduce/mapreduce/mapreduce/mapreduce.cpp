#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctype.h>
#include <algorithm>
#include <sstream>
#include <map>
#include<ctime>

using namespace std;

map<string, vector<int> > shuff;
map<string, int> reduce;
vector<map<string, int> > res;

vector<pair<string, int> > mapping(string x);
void shuffing(vector<pair<string, int> > &smapping);
void Reducing();

void reading()
{
	string filename = "D:\\016853\\msup\\mapreduce\\hamlet.txt";
	fstream fin;
	fin.open(filename.c_str(), ios::in);

	string x;
	while (getline(fin, x))
	{
		x.erase(remove_if(x.begin(), x.end(), static_cast<int(*)(int)>(&ispunct)), x.end());
		transform(x.begin(), x.end(), x.begin(), ::tolower);
		//cout << x << endl;
		vector<pair<string, int> > smapping=mapping(x);
		shuffing(smapping);
	}
}

vector<pair<string, int> > mapping(string x)
{
	vector<string> res;
	vector<pair<string, int> > smapping;
	string result;
	stringstream input(x);
	while (input >> result)
	{
		//res.push_back(result);
		pair<string, int> t(result, 1);
		smapping.push_back(t);
	}
	/*
	for (int i = 0; i < res.size(); i++)
	{
		pair<string, int> t(res[i], 1);
		smapping.push_back(t);
	}
	*/
	return smapping;
}

void shuffing(vector<pair<string, int> > &smapping)
{
	for (auto i = 0; i < smapping.size(); i++)
	{
		string tmp = smapping[i].first;
		//cout << tmp<<endl;
		if (shuff.find(tmp) == shuff.end())
		{
			vector<int> v;
			v.push_back(1);
			shuff[tmp]= v;
		}
		else
		{
			vector<int> v = shuff[tmp];
			v.push_back(1);
			shuff[tmp] = v;
		}
		
	}
}

void Reducing()
{
	for (auto iter = shuff.begin(); iter != shuff.end(); iter++)
	{
		//cout << iter->first <<" "<< iter->second.size() << endl;
		reduce[iter->first] = iter->second.size();
		res.push_back(reduce);
	}
}


int main()
{
	clock_t startTime, endTime;
	startTime = clock();//计时开始
	reading();
	Reducing();
	cout <<"单词数量："<< res.size() << endl;
	endTime = clock();//计时结束
	cout << "The run time is: " << (double)(endTime - startTime) / CLOCKS_PER_SEC << "s" << endl;
	return 0;
}